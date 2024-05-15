package com.tiendamusica.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class TiendaMusicaController implements Initializable {
    private boolean esAdministrador;
    private boolean esUsuario;
    @FXML
    private Button btnMisCanciones;
    @FXML
    private AnchorPane panelIzquierdo;
    @FXML
    private Button btnBuscador;
    @FXML
    private AnchorPane panelDerecho;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnAgregar;
    @FXML
    private AnchorPane panelFormulario;
    @FXML
    private Button btnFav;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void showFav(ActionEvent event) {

    }

    @FXML
    void showBuscador(ActionEvent event) {

    }

    @FXML
    void showAgregar(ActionEvent event) {

    }

    @FXML
    void showMisCanciones(ActionEvent event) {
        try {
            Node node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/tiendamusica/app/interfaces/MySongs-view.fxml")));
            panelFormulario.getChildren().setAll(node);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void showEliminar(ActionEvent event) {

    }

    //Abre interfas de funciones de usuario
    private void redireccionarAdmin() throws IOException {

        Stage Stagep = new Stage();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Admin-view.fxml"));

        Parent p = loader.load();
        Scene s = new Scene(p, 650, 450);

        Stagep.setScene(s);
        Stagep.show();
        closed();
    }


    public void MisCancionesButtonClick()throws IOException{
        //Validar si es usuario o admin
        if(esAdministrador){
            redireccionarAdmin();
        }else{
            //Implemntar funcion de actulizar la tabla de la interfas con la musica del usuario
            System.out.println("Update table whith my music");
        }
    }

    //Mostrar alerta
    public  void myAlerta(String alerta){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Error");
        a.setContentText(alerta);
        a.showAndWait();
    }
    //Limpiar todos los campos


    public void closed(){
        //Stage currentStage = (Stage) usuarioText.getScene().getWindow();
       // currentStage.close();
    }
    public void setEsAdministrador(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }

    public void setEsUsuario(boolean esUsuario) {
        this.esUsuario = esUsuario;
    }

}
