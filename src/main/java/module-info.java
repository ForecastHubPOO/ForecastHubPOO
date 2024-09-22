module com.mycompany.forecasthub {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.forecasthub to javafx.fxml;
    exports com.mycompany.forecasthub;
    requires io.github.cdimascio.dotenv.java;
    requires org.json;
}
