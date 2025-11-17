package br.com.conversor;

// Importações importantes
import com.google.gson.annotations.SerializedName;
import java.util.Map;

// ORIENTAÇÃO ESPECIAL (Java 11):
// Esta classe é o "molde" que o Gson usará.
// Usamos o @SerializedName para ligar os nomes do JSON (com _)
// com os nomes das nossas variáveis (em camelCase).

public class TaxaDeCambioResponse {

    @SerializedName("result")
    private final String result;

    @SerializedName("base_code")
    private final String baseCode;

    // ORIENTAÇÃO ESPECIAL (A parte mais legal!)
    // "conversion_rates" no JSON é um objeto com muitas chaves (BRL, EUR...)
    // O Gson é inteligente o bastante para converter isso
    // automaticamente em um "Mapa" do Java.
    @SerializedName("conversion_rates")
    private final Map<String, Double> rates;

    // Construtor que o Gson usa para criar o objeto
    public TaxaDeCambioResponse(String result, String baseCode, Map<String, Double> rates) {
        this.result = result;
        this.baseCode = baseCode;
        this.rates = rates;
    }

    // "Getters" - Métodos para nós podermos LER os dados
    // depois que o Gson preencher o objeto.
    
    public String getResult() {
        return result;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

} // <-- ESTA CHAVE PROVAVELMENTE ESTAVA FALTANDO