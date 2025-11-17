package br.com.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ApiService {

    private final String API_KEY = "ac6975945de46df3d8bce78e";
    private final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public TaxaDeCambioResponse obterTaxas(String moedaBase) {

        URI uri = URI.create(API_URL + API_KEY + "/latest/" + moedaBase);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Falha na API: " + response.statusCode());
            }

            String jsonBody = response.body();
            return new Gson().fromJson(jsonBody, TaxaDeCambioResponse.class);

        } catch (Exception e) {
            // ERRO DO 'f' CORRIGIDO AQUI
            throw new RuntimeException("Erro ao consultar API: " + e.getMessage());
        }
    }
} // CHAVE EXTRA REMOVIDA DAQUI