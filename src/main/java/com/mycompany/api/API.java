package com.mycompany.api;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class API {
    private Dotenv dotenv = Dotenv.load();
    private String apiKey = dotenv.get("API_KEY");
    private String urlString = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    
    public JSONObject getWeather(String location) {
        JSONObject data = null;
        try {
            URL url = new URL(urlString + location + "?" + "key=" + apiKey);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int code = conn.getResponseCode();

            if (code == 200) {
                InputStream inputStream = conn.getInputStream();
                String response = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                data = new JSONObject(response);
            }
            else {
                data = new JSONObject("{response: 400}");
            }
        } catch (Exception e) {
            data = new JSONObject("{response: 400}");
        } finally {
            return data;
        }
    }
}