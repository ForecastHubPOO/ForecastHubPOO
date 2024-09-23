package com.mycompany.forecasthub;

import java.io.IOException;
import javafx.fxml.FXML;

public class MudarParaTelaDePrevisao {

    @FXML
    private void mudarParaTelaDePrevisao() throws IOException {
        App.setRoot("TelaDePrevisao");
    }
}