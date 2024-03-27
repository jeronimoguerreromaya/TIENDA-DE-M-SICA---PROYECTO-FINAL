package com.tiendamusica.app.demo2;

import com.tiendamusica.Logica.TiendaMusica;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginController {

    TiendaMusica myTienda;
    @FXML
    private TextField usuarioText;
    @FXML
    private PasswordField claveText;


    public void ingresarButtonClick (){
        myTienda = new TiendaMusica();

        //variables auxiliares
        String user = usuarioText.getText();
        String password = claveText.getText();


        if(myTienda.validarIngreso(user,password)){

                redireccionarTiendaMusica();
                System.out.println("ingreso");



        }else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Error");
            a.setContentText("Datos incorrectas");
            a.showAndWait();
        }
        usuarioText.clear();
        claveText.clear();
    }
    public void registrarseButtonClick (){

    }

    private void redireccionarTiendaMusica()  {

        try {
            Stage Stagep = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("TiendaMusica-view.fxml"));

            Parent p = loader.load();
            Scene s = new Scene(p, 1500, 800);

            Stagep.setScene(s);
            Stagep.show();


        }catch (Exception e){

        }



    }

}
