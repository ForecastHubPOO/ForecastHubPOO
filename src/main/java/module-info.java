module com.mycompany.ForecastHUB {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.principal to javafx.fxml;
    exports br.edu.principal;
    requires io.github.cdimascio.dotenv.java;
    requires org.json;
}
