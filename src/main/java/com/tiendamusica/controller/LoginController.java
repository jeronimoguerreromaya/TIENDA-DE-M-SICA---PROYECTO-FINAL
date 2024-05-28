package com.tiendamusica.controller;

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
    public void ingresarButtonClick ()throws IOException{
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

    private void redireccionarTiendaMusica() throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tiendamusica/app/interfaces/TiendaMusica-view.fxml"));            Parent root = loader.load();
            Scene scene = new Scene(root, 608, 402);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            TiendaMusicaController tiendaMusicaController = loader.getController();

            String user = usuarioText.getText();
            String password = claveText.getText();
            boolean esAdministrador = myTienda.getAdmin().esAdministrador(user, password);
            tiendaMusicaController.setEsAdministrador(esAdministrador);
            tiendaMusicaController.setEsUsuario(!esAdministrador);

            closed();
        } catch (IOException e) {
            e.printStackTrace();
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

    public void closed(){
        Stage currentStage = (Stage) usuarioText.getScene().getWindow();
        currentStage.close();
    }

}
