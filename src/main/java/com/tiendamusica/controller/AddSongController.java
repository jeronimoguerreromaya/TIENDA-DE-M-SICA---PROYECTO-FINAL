package com.tiendamusica.controller;

import com.tiendamusica.Logica.TiendaMusica;
import com.tiendamusica.exceptions.AtributoVacioException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.tiendamusica.Logica.TiendaMusica.mostrarMensaje;

public class AddSongController implements Initializable {
    @FXML
    private TextField txtDuracion;
    @FXML
    private Button btnLimpiar;
    @FXML
    private TextField txtNombreCancion;
    @FXML
    private TextField txtNombreAlbum;
    @FXML
    private Button btnAgregar;
    @FXML
    private TextField txtURL;
    @FXML
    private TextField txtGenero;
    private TiendaMusica tienda;

    @FXML
    void showAgregar(ActionEvent event) throws MalformedURLException {
        String nombre = txtNombreCancion.getText();
        String nombreAlbum = txtNombreAlbum.getText();
        String duracion = txtDuracion.getText();
        String genero = txtGenero.getText();
        URL url = null;
        try {
            url = new URL(txtURL.getText());
            TiendaMusica.agregarCancion(nombre, nombreAlbum, duracion, genero, url);
            limpiarCampos(); // Limpia los campos después de agregar la canción
        } catch (MalformedURLException e) {
            mostrarMensaje("Error", "URL Inválida", "La URL proporcionada no es válida.", Alert.AlertType.ERROR);
        } catch (AtributoVacioException e) {
            mostrarMensaje("Error", "Datos Faltantes", e.getMessage(), Alert.AlertType.ERROR);
        } catch (IOException e) {
            mostrarMensaje("Error", "Problema al Agregar Canción", "Hubo un problema al intentar agregar la canción.", Alert.AlertType.ERROR);
        }
    }

    private void limpiarCampos() {
        txtDuracion.clear();
        txtNombreCancion.clear();
        txtNombreAlbum.clear();
        txtURL.clear();
        txtGenero.clear();
    }
    @FXML
    void showLimpiar(ActionEvent event) {
        limpiarCampos();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {    }
}

