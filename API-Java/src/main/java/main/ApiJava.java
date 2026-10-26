/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author juans
 */

import modelo.Post;
import Servicio.ApiService;
import java.io.IOException;

public class ApiJava {
     public static void main(String[] args) {
        System.out.println("Consumiendo API de Fake API...");
        
        ApiService apiService = new ApiService();
        
        try {
            // Se remueve 'new' antes de la llamada al método
            Post post = apiService.getPost(3);
            
            if (post != null) {
                System.out.println("Recibiendo post:");
                System.out.println("ID: " + post.getId());
                System.out.println("Título: " + post.getTitle());
                System.out.println("Cuerpo: " + post.getBody());
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al realizar la petición:");
            e.printStackTrace();
        }
    }
}
