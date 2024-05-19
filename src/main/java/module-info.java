module com.tiendamusica.app.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.tiendamusica.app to javafx.fxml;
    exports com.tiendamusica.app;
    exports com.tiendamusica.controller;
    opens com.tiendamusica.controller to javafx.fxml;
}