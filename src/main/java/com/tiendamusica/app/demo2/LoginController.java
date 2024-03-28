package com.tiendamusica.app.demo2;

import com.tiendamusica.Logica.TiendaMusica;
import com.tiendamusica.Logica.Usuario;
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
    @FXML
    private TextField newUsuarioText;
    @FXML
    private TextField newGmailText;
    @FXML
    private PasswordField newPasswordText;

    //Accion de inicio de sesion
    public void ingresarButtonClick (){
        myTienda = new TiendaMusica();

        //variables auxiliares
        String user = usuarioText.getText();
        String password = claveText.getText();

        //Validar que no haya campos vacios
        if(!user.isEmpty()&&!password.isEmpty()){
            //Validar usuario
            if(myTienda.validarIngreso(user,password)){

                redireccionarTiendaMusica();
                System.out.println("ingreso usuario");
            }else {
                //Validar administrador
                if(myTienda.getAdmin().esAdministrador(user,password)){
                    redireccionarTiendaMusica();
                    System.out.println("ingreso Administrador");
                }else{
                    myAlerta("Datos incorrectos");
                }

            }
            clearALl();
        }else {
            myAlerta("No se permiten campos vacios");
        }
    }
    //Accion de registrar un nuevo usuario
    public void registrarseButtonClick (){
        myTienda = new TiendaMusica();

        //variables auxiliares
        String user = newUsuarioText.getText();
        String password = newPasswordText.getText();
        String gmail = newGmailText.getText();
        //Crear un usuario temporal
        Usuario newUsuario = new Usuario(user,password,gmail);

        if(!user.isEmpty()&&!password.isEmpty()&&!gmail.isEmpty()){
            //Registrar usuario
            myTienda.registrarUsuario(newUsuario);
            clearALl();
        }else {
            myAlerta("No se permiten campos vacios");
        }
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
    //Mostrar alerta
    public  void myAlerta(String alerta){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Error");
        a.setContentText(alerta);
        a.showAndWait();
    }
    //Limpiar todos los campos
    public void clearALl(){
        usuarioText.clear();
        claveText.clear();
        newUsuarioText.clear();
        newPasswordText.clear();
        newGmailText.clear();
    }

}
