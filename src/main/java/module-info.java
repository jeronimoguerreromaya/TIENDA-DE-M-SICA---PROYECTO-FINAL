module com.tiendamusica.app.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.tiendamusica.app.demo2 to javafx.fxml;
    exports com.tiendamusica.app.demo2;
}