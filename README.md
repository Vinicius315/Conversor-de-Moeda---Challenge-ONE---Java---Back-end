

# Conversor de Moeda - Challenge ONE Back-end

## 📄 Descrição do Projeto

Este é o primeiro projeto desenvolvido como parte do **Challenge ONE - Java Back-end**, uma parceria entre a [Alura](https://www.alura.com.br/) e a [Oracle](https://www.oracle.com/).

O objetivo é criar um conversor de moedas funcional que roda no console (terminal). O aplicativo consome uma API pública (ExchangeRate-API) para obter as taxas de câmbio em tempo real e realizar as conversões.

## ✨ Funcionalidades

O aplicativo oferece um menu interativo no console com as seguintes opções:

  * Conversões populares pré-definidas (USD, BRL, EUR, ARS, JPY).
  * Opção de conversão personalizada, permitindo ao usuário digitar qualquer código de moeda (ex: "CAD" para Dólar Canadense).
  * Menu em loop que permite múltiplas conversões até que o usuário decida sair.
  * Tratamento de erros para entradas inválidas (como moedas não encontradas ou digitação de letras em vez de números).

## 🛠️ Tecnologias Utilizadas

  * **Java 11:** Linguagem principal do projeto.
  * **Maven:** Para gerenciamento de dependências e build do projeto.
  * **Java HTTP Client:** (do pacote `java.net.http`) Para fazer as requisições à API.
  * **Gson:** Biblioteca do Google para desserializar (converter) as respostas JSON da API em objetos Java.
  * **ExchangeRate-API:** API externa utilizada para buscar as taxas de câmbio.
  * **JUnit 4:** Para os testes unitários.

## 🚀 Como Executar

1.  Certifique-se de ter o [Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) e o [Maven](https://maven.apache.org/download.cgi) instalados e configurados no seu PATH.

2.  Clone o repositório:

    ```bash
    git clone https://github.com/Vinicius315/Conversor-de-Moeda---Challenge-ONE---Java---Back-end.git
    ```

3.  Navegue até a pasta raiz do projeto (onde o `pom.xml` está):

    ```bash
    cd Conversor-de-Moeda---Challenge-ONE---Java---Back-end/conversor-moedas
    ```

4.  Compile, teste e empacote o projeto com o Maven:

    ```bash
    mvn clean install
    ```

5.  Após o "BUILD SUCCESS", copie as dependências (como o Gson) para a pasta `target`:

    ```bash
    mvn dependency:copy-dependencies
    ```

6.  Execute o aplicativo:

    ```bash
    java -cp target/classes:target/dependency/* br.com.conversor.App
    ```

7.  O menu interativo aparecerá no seu terminal.

## 🏛️ Estrutura do Projeto

```
conversor-moedas/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── br/
│   │           └── com/
│   │               └── conversor/
│   │                   ├── App.java                 # (Classe principal, com o menu)
│   │                   ├── ApiService.java          # (Faz a chamada para a API)
│   │                   └── TaxaDeCambioResponse.java # (Molde para a resposta JSON)
│   └── test/
│       └── java/
│           └── br/
│               └── com/
│                   └── conversor/
│                       └── AppTest.java           # (Testes unitários)
├── .gitignore
├── pom.xml                                      # (Configuração do Maven)
└── README.md                                    # (Este arquivo)
```

## 👨‍💻 Autor

Feito por **Vinícius** 👋

-----
