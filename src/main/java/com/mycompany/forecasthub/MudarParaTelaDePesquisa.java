package com.mycompany.forecasthub;

import java.io.IOException;
import javafx.fxml.FXML;

public class MudarParaTelaDePesquisa {

    @FXML
    private void mudarParaTelaDePesquisa() throws IOException {
        App.setRoot("TelaDePesquisa");
    }
}
