package modelo;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TipoCambio {

    public Moneda buscaTipoCambio(String tipoMoneda) {
        try (BufferedReader reader = new BufferedReader(new FileReader("ApiKey.txt"))) {
            String APIKEY = reader.readLine().trim();  // Lee la API key de la primera línea
            URI direccionUri = URI.create("https://v6.exchangerate-api.com/v6/" + APIKEY + "/latest/" + tipoMoneda);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(direccionUri).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            MonedaDTO monedaDTO = new Gson().fromJson(response.body(), MonedaDTO.class);
            return new Moneda(monedaDTO);

        } catch (IOException e) {
            System.out.println("Archivo no encontrado o error de lectura.");
        } catch (InterruptedException e) {
            System.out.println("Error al enviar la solicitud.");
        }
        return null;
    }
}
