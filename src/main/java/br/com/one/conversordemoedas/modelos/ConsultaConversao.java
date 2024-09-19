package br.com.one.conversordemoedas.modelos;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversao {

    public static void buscaConversao(String moedaBase, String moedaAlvo,double valor) {
        Gson gson = new Gson();
        String endereco = "https://v6.exchangerate-api.com/v6/" + System.getenv("API_KEY") + "/pair/" + moedaBase + "/" + moedaAlvo + "/" + valor;

        try {
            var resposta = getResposta(endereco);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Problema ao tentar gerar reposta :(");
        } catch (UncheckedIOException e) {
            throw new RuntimeException("Problema ao tentar gerar cliente :(");
        }
    }

    private static HttpResponse<String> getResposta(String address) throws IOException, InterruptedException, UncheckedIOException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest pedido = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        return cliente
                .send(pedido, HttpResponse.BodyHandlers.ofString());
    }

}
