package com.mycompany.forecasthub;

import static com.mycompany.api.API.getWeather;
import java.io.IOException;
import java.text.ParseException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private void mudarParaTelaDePrevisao(ActionEvent event) throws IOException, ParseException {
        location = myTextField.getText();
        boolean dataFound = true;
        JSONObject data = getWeather(location);
        
        try {
            data.getString("address");
        } catch (Exception e) {
            dataFound = false;
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setHeaderText("Endereço não encontrado");
            errorAlert.showAndWait();
        } finally {
            if (dataFound) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("TelaDePrevisao.fxml"));
                root = loader.load();

                ControllerTelaDePrevisao controllerTelaDeRevisao = loader.getController();
                controllerTelaDeRevisao.displayWeather(data);

                stage = (Stage)((Node)event.getSource()).getScene().getWindow();  
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                myTextField.setText("");
                dataFound = true;
            }
        }
    }
}