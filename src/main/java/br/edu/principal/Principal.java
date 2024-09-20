/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.principal;

import br.edu.api.API;
import java.io.IOException;
import java.net.ProtocolException;
import org.json.JSONObject;

/**
 *
 * @author levis
 */
public class Principal {
    public static void main(String[] args) throws ProtocolException, IOException {
        API api = new API();
        JSONObject data = api.getWeather("Fortaleza");
        System.out.println(data.get("latitude"));
    }
}
