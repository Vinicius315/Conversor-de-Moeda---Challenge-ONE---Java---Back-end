package br.com.conversor;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiService apiService = new ApiService();

        while (true) {
            System.out.println("*************************************************");
            System.out.println("Bem-vindo(a) ao Conversor de Moeda!");
            System.out.println("Escolha uma das 10+ conversões populares ou '0' para sair:");
            System.out.println("\n1) [USD] Dólar Americano => [BRL] Real Brasileiro");
            System.out.println("2) [BRL] Real Brasileiro => [USD] Dólar Americano");
            System.out.println("3) [EUR] Euro => [BRL] Real Brasileiro");
            System.out.println("4) [BRL] Real Brasileiro => [EUR] Euro");
            System.out.println("5) [USD] Dólar Americano => [EUR] Euro");
            System.out.println("6) [EUR] Euro => [USD] Dólar Americano");
            System.out.println("7) [USD] Dólar Americano => [ARS] Peso Argentino");
            System.out.println("8) [ARS] Peso Argentino => [USD] Dólar Americano");
            System.out.println("9) [USD] Dólar Americano => [JPY] Iene Japonês");
            System.out.println("10) [JPY] Iene Japonês => [USD] Dólar Americano");
            System.out.println("\n11) Outra conversão (Digitar moedas manualmente)");
            System.out.println("0) Sair");
            System.out.println("*************************************************");
            System.out.print("Digite sua opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); 

                if (opcao == 0) {
                    System.out.println("\nObrigado por usar o conversor. Até logo!");
                    break; 
                }

                String moedaBase = "";
                String moedaAlvo = "";

                switch (opcao) {
                    case 1: moedaBase = "USD"; moedaAlvo = "BRL"; break;
                    case 2: moedaBase = "BRL"; moedaAlvo = "USD"; break;
                    case 3: moedaBase = "EUR"; moedaAlvo = "BRL"; break;
                    case 4: moedaBase = "BRL"; moedaAlvo = "EUR"; break;
                    case 5: moedaBase = "USD"; moedaAlvo = "EUR"; break;
                    case 6: moedaBase = "EUR"; moedaAlvo = "USD"; break;
                    case 7: moedaBase = "USD"; moedaAlvo = "ARS"; break;
                    case 8: moedaBase = "ARS"; moedaAlvo = "USD"; break;
                    case 9: moedaBase = "USD"; moedaAlvo = "JPY"; break;
                    case 10: moedaBase = "JPY"; moedaAlvo = "USD"; break;
                    case 11:
                        System.out.print("Digite a moeda de ORIGEM (ex: USD): ");
                        moedaBase = scanner.nextLine().toUpperCase();
                        System.out.print("Digite a moeda de DESTINO (ex: BRL): ");
                        moedaAlvo = scanner.nextLine().toUpperCase();
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.\n");
                        continue; 
                }

                System.out.print("Digite o valor que deseja converter: ");
                double valor = scanner.nextDouble();

                System.out.println("\nBuscando taxas de " + moedaBase + "...");
                TaxaDeCambioResponse resposta = apiService.obterTaxas(moedaBase);

                Map<String, Double> todasAsTaxas = resposta.getRates();
                if (todasAsTaxas.containsKey(moedaAlvo)) {
                    
                    // ERRO 'moetoedasAlvo' CORRIGIDO AQUI
                    double taxa = todasAsTaxas.get(moedaAlvo); 
                    double valorConvertido = valor * taxa;

                    System.out.println("--- RESULTADO DA CONVERSÃO ---");
                    System.out.printf("%.2f [%s] equivalem a %.2f [%s]\n",
                            valor, moedaBase, valorConvertido, moedaAlvo);
                    System.out.printf("(Taxa de câmbio: 1 %s = %.4f %s)\n\n",
                            moedaBase, taxa, moedaAlvo);
                } else {
                    System.out.println("Moeda de destino '" + moedaAlvo + "' não encontrada nas taxas.\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nErro: Entrada inválida. Por favor, digite um número.\n");
                scanner.nextLine(); 
            } catch (RuntimeException e) {
                System.out.println("\nErro: " + e.getMessage() + "\n");
            }
        }
        scanner.close(); 
    }
} // CHAVE EXTRA REMOVIDA DAQUI