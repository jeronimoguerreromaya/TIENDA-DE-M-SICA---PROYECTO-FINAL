package com.tiendamusica.app.demo2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class TiendaMusicaController {

        private boolean esAdministrador;
        private boolean esUsuario;


        public void MisCancionesButtonClick()throws IOException{
            //Validar si es usuario o admin
            if(esAdministrador){
                redireccionarAdmin();
            }else{
                //Implemntar funcion de actulizar la tabla de la interfas con la musica del usuario
                System.out.println("Update table whith my music");
            }
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
