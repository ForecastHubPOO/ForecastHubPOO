package com.mycompany.forecasthub;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.json.JSONObject;

public class ControllerTelaDePrevisao {

    @FXML
    private void mudarParaTelaDePesquisa() throws IOException {
        App.setRoot("TelaDePesquisa");
    }
    
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
    
    public void displayWeather(JSONObject data) {
        CP.setText(data.getString("resolvedAddress"));
    }
}