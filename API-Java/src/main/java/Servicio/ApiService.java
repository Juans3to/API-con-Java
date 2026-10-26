/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author juans
 */

import modelo.Post;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class ApiService {

    // Crear el cliente HTTP estándar de Java 11+
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    // Se agrega el '/' al final para construir bien la URL
    private static final String API_URL = "https://jsonplaceholder.typicode.com/posts/";

    public Post getPost(int id) throws IOException, InterruptedException {
        // Construir la petición
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(API_URL + id))
                .header("Accept", "application/json")
                .build();

        // Enviar la petición
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Verificar el estado de la respuesta
        if (response.statusCode() != 200) {
            System.out.println("Error en la peticion: " + response.statusCode());
            return null; // O lanzar una excepción según la lógica de tu app
        }

        // Mapear la respuesta JSON
        String jsonString = response.body();
        JSONObject jsonObject = new JSONObject(jsonString);

        // Retornar la instancia de Post
        return new Post(jsonObject);
    }
}

