package com.mycompany.forecasthub;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MudarParaTelaDePrevisao {

    
    @FXML
    private TextField myTextField;
    
    String pesquisa;
    
    
    @FXML
    private void mudarParaTelaDePrevisao() throws IOException {
        pesquisa = myTextField.getText();
        System.out.println(pesquisa);
        App.setRoot("TelaDePrevisao");
    }
}