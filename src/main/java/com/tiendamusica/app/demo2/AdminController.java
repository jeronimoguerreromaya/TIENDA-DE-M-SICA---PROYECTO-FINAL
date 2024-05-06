package com.tiendamusica.app.demo2;

import com.tiendamusica.Logica.TiendaMusica;
import com.tiendamusica.myTools.Estado;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import javax.swing.*;

public class AdminController {
    TiendaMusica myTienda = new TiendaMusica();
    @FXML
    private TextField codigo;
    @FXML
    private TextField nombre;
    @FXML
    private TextField nacionalidad;
    @FXML
    private ComboBox<Estado> estado;
    @FXML
    private TextField artista;
    @FXML
    private TextField nombreCancion;
    @FXML
    private TextField nombreAlbun;
    @FXML
    private TextField duracion;
    @FXML
    private DatePicker fecha;
    @FXML
    private TextField genero;
    @FXML
    private TextField url;
    @FXML
    private Button cargarCancionButton; // Botón de Cargar Canción
    @FXML
    private Button agregarCancionButton; // Botón de Agregar Canción
    TiendaMusica tM = new TiendaMusica();

    public void initialize() {
        estado.getItems().addAll(Estado.values());
    }


    public void CrearArtistaButtonClick() {
        // Verifica si alguno de los campos está vacío
        if (codigo.getText().isEmpty() || nombre.getText().isEmpty() || nacionalidad.getText().isEmpty() || estado.getValue() == null) {
            // Si alguno de los campos está vacío, muestra una alerta
            myAlerta("No se permiten campos vacíos. Por favor, completa todos los campos antes de continuar.");

        } else {

            String codigoArtista = codigo.getText();
            String nombreArtista = nombre.getText();
            String nacionalidadArtista = nacionalidad.getText();
            Estado estadoArtista = estado.getValue();

            //Implementar metodo de crear artista en logica de la tienda
            myTienda.crearArtista(null);

            clearAllFields();

        }
    }

    public void agregarCancionButtonClick() {

        // Verifica si alguno de los campos está vacío
        if (artista.getText().isEmpty() || nombreCancion.getText().isEmpty() ||
                nombreAlbun.getText().isEmpty() || duracion.getText().isEmpty() ||
                fecha.getValue() == null || genero.getText().isEmpty() ||
                url.getText().isEmpty()) {

            myAlerta("No se permiten campos vacíos. Por favor, completa todos los campos antes de continuar.");
        } else {
            // Si todos los campos están llenos, puedes proceder con la acción deseada
            String artistaNombre = artista.getText();
            String cancionNombre = nombreCancion.getText();
            String albumNombre = nombreAlbun.getText();
            String duracionCancion = duracion.getText();
            String generoCancion = genero.getText();
            String urlCancion = url.getText();
            java.time.LocalDate fechaCancion = fecha.getValue();

            //Implementar metodo de crear cancion en logica de la tienda
            //myTienda.crearCancion(null);

            clearAllFields();


        }


    }

    public void myAlerta(String message) {
        Alert alerta = new Alert(AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText("Campos vacíos");
        alerta.setContentText(message);
        alerta.showAndWait();
    }
    public void clearAllFields() {
        // Limpia los campos TextField
        codigo.clear();
        nombre.clear();
        nacionalidad.clear();
        artista.clear();
        nombreCancion.clear();
        nombreAlbun.clear();
        duracion.clear();
        genero.clear();
        url.clear();

        // Restablece el ComboBox a null
        estado.setValue(null);

        // Restablece el DatePicker a null
        fecha.setValue(null);
    }



}
