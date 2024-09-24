package com.mycompany.forecasthub;

import static com.mycompany.api.API.getWeather;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONObject;

public class ControllerTelaDePesquisa {

    
    @FXML
    private TextField myTextField;
    private Parent root;
    String location;
    
    private Stage stage;
    private Scene scene;
    
    @FXML
    private void mudarParaTelaDePrevisao(ActionEvent event) throws IOException {
        location = myTextField.getText();
        JSONObject data = getWeather(location);
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("TelaDePrevisao.fxml"));
        root = loader.load();
        
        ControllerTelaDePrevisao controllerTelaDeRevisao = loader.getController();
        controllerTelaDeRevisao.displayWeather(data);
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();  
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
        //App.setRoot("TelaDePrevisao");
    }
}