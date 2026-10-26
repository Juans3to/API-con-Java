/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juans
 */

import org.json.JSONObject;

public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Post(JSONObject json) {
        this.userId = json.getInt("userId");
        this.id = json.getInt("id");
        this.title = json.getString("title");
        this.body = json.getString("body");
    }

    // Métodos Getter necesarios para acceder a los datos
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Post {id: " + id + ", title: " + title + ", body: " + body + "}";
    }
}
