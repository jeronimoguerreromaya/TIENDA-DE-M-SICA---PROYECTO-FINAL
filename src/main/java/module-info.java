module com.tiendamusica.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens com.tiendamusica.app to javafx.fxml;
    exports com.tiendamusica.app;
    exports com.tiendamusica.controller;
    opens com.tiendamusica.controller to javafx.fxml;
    opens com.tiendamusica.Logica to javafx.base;
}