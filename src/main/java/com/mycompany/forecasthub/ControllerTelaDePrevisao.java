package com.mycompany.forecasthub;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.json.JSONArray;
import org.json.JSONObject;

public class ControllerTelaDePrevisao {
    
       @FXML
    public Label CP;
    
    @FXML
    public Label x1;
    
    @FXML
    private Label x2;
    
    @FXML
    private Label x3;
    
    @FXML
    private Label x4;
    
    @FXML
    private Label x5;
    
    @FXML
    private Label y1;
    
    @FXML
    private Label y2;
    
    @FXML
    private Label y3;
    
    @FXML
    private Label y4;
    
    @FXML
    private Label y5;
    
    @FXML
    private Label D1;
    
    @FXML
    private Label D2;
    
    @FXML
    private Label D3;
    
    @FXML
    private Label celsius;
        
    @FXML
    private Label ST;
    
    
    @FXML
    private void mudarParaTelaDePesquisa() throws IOException {
        App.setRoot("TelaDePesquisa");
    }

    public int convertTemp(float temp) {
        int newTemp = (int) (5 * (temp - 32)) / 9;
        return newTemp;
    }
    
    public static String getDayName(int day, Locale locale) {
        DateFormatSymbols symbols = new DateFormatSymbols(locale);
        String[] dayNames = symbols.getWeekdays();
        return dayNames[day].substring(0, 1).toUpperCase() + dayNames[day].substring(1);
    }

    
    public void displayWeather(JSONObject data) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        Locale localeBr = new Locale("pt", "BR");
        
        CP.setText(data.getString("resolvedAddress"));
        celsius.setText(Integer.toString(convertTemp(data.getJSONArray("days").getJSONObject(1).getFloat("temp"))));
        
        Date convertedCurrentDate = parser.parse(data.getJSONArray("days").getJSONObject(2).getString("datetime"));
        Calendar c = Calendar.getInstance();
        c.setTime(convertedCurrentDate);
        int dow = c.get(Calendar.DAY_OF_WEEK);
        D1.setText(getDayName(dow, localeBr));

        convertedCurrentDate = parser.parse(data.getJSONArray("days").getJSONObject(3).getString("datetime"));
        c = Calendar.getInstance();
        c.setTime(convertedCurrentDate);
        dow = c.get(Calendar.DAY_OF_WEEK);
        D2.setText(getDayName(dow, localeBr));
        
        convertedCurrentDate = parser.parse(data.getJSONArray("days").getJSONObject(3).getString("datetime"));
        c = Calendar.getInstance();
        c.setTime(convertedCurrentDate);
        dow = c.get(Calendar.DAY_OF_WEEK);
        D3.setText(getDayName(dow, localeBr));
        
        x1.setText(sdf.format(parser.parse(data.getJSONArray("days").getJSONObject(0).getString("datetime"))));
        y1.setText(Integer.toString(convertTemp(data.getJSONArray("days").getJSONObject(0).getFloat("tempmax"))) + "°/" + Integer.toString(convertTemp(data.getJSONArray("days").getJSONObject(0).getFloat("tempmin"))) + "°");

        x2.setText(sdf.format(parser.parse(data.getJSONArray("days").getJSONObject(1).getString("datetime"))));
        y2.setText(Integer.toString(convertTemp(data.getJSONArray("days").getJSONObject(1).getFloat("tempmax"))) + "°/" + Integer.toString(convertTemp(data.getJSONArray("days").getJSONObject(1).getFloat("tempmin"))) + "°");

        x3.setText(sdf.format(parser.parse(data.getJSONArray("days").getJSONObject(2).getString("datetime"))));
        y3.setText(Integer.toString(convertTemp(data.getJSONArray("days").getJSONObject(2).getFloat("tempmax"))) + "°/" + Integer.toString(convertTemp(data.getJSONArray("days").getJSONObject(2).getFloat("tempmin"))) + "°");

        x4.setText(sdf.format(parser.parse(data.getJSONArray("days").getJSONObject(3).getString("datetime"))));
        y4.setText(Integer.toString(convertTemp(data.getJSONArray("days").getJSONObject(3).getFloat("tempmax"))) + "°/" + Integer.toString(convertTemp(data.getJSONArray("days").getJSONObject(3).getFloat("tempmin"))) + "°");

        x5.setText(sdf.format(parser.parse(data.getJSONArray("days").getJSONObject(4).getString("datetime"))));
        y5.setText(Integer.toString(convertTemp(data.getJSONArray("days").getJSONObject(4).getFloat("tempmax"))) + "°/" + Integer.toString(convertTemp(data.getJSONArray("days").getJSONObject(4).getFloat("tempmin"))) + "°");
    }
    
    
}