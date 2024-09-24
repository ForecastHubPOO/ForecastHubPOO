package com.mycompany.api;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    private static Dotenv dotenv = Dotenv.load();
    private static String apiKey = dotenv.get("API_KEY");
    private static String urlString = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/";
    
    public static JSONObject getWeather(String location) {
        JSONObject data = null;
        Calendar previousTime = Calendar.getInstance();
        previousTime.setTime(new Date());
        previousTime.add(Calendar.DATE, -1);
        
        Calendar nextTime = Calendar.getInstance();
        nextTime.setTime(new Date());
        nextTime.add(Calendar.DATE, 3);

        try {
            URL url = new URL(urlString + location + "/" + new SimpleDateFormat("yyyy-MM-dd").format(previousTime.getTime()) + "/" + new SimpleDateFormat("yyyy-MM-dd").format(nextTime.getTime()) + "?" + "key=" + apiKey);
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