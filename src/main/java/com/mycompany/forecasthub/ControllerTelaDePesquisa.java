package com.mycompany.forecasthub;

import static com.mycompany.api.API.getWeather;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import org.json.JSONObject;

public class ControllerTelaDePesquisa {

    
    @FXML
    private TextField myTextField;
    private Parent root;
    String location;
    
    @FXML
    private void mudarParaTelaDePrevisao() throws IOException {
        location = myTextField.getText();
        JSONObject data = getWeather(location);
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TelaDePrevisao.fxml"));
        root = loader.load();
        ControllerTelaDePrevisao controllerTelaDeRevisao = loader.getController();
        controllerTelaDeRevisao.displayWeather(data);
        
        App.setRoot("TelaDePrevisao");
    }
}