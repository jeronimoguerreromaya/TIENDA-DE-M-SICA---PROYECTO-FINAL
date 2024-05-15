package com.tiendamusica.controller;

import com.tiendamusica.Logica.Artista;
import com.tiendamusica.Logica.Cancion;
import com.tiendamusica.Logica.TiendaMusica;
import com.tiendamusica.myTools.BinaryTree;
import com.tiendamusica.myTools.Estado;
import com.tiendamusica.myTools.ListaDobleEnlazada;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class AdminController {
    TiendaMusica myTienda ;
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
            myTienda = new TiendaMusica();
            String codigoArtista = codigo.getText();
            String nombreArtista = nombre.getText();
            String nacionalidadArtista = nacionalidad.getText();
            Estado estadoArtista = estado.getValue();

            Artista artista1 = new Artista();
                artista1.setNombre(nombreArtista);
                artista1.setCodigo(codigoArtista);
                artista1.setEstado(estadoArtista);
                artista1.setNacionalidad(nacionalidadArtista);

            myTienda.crearArtista(artista1);

            clearAllFields();

        }
    }

    public void CargarCancionButtonClick(){

    }

    public void agregarCancionButtonClick() {


       // nombreAlbun.getText().isEmpty() || duracion.getText().isEmpty() ||
               // fecha.getValue() == null || genero.getText().isEmpty() ||
               // url.getText().isEmpty()
        // Verifica si alguno de los campos está vacío
        if ( nombreCancion.getText().isEmpty()
               ) {

            myAlerta("No se permiten campos vacíos. Por favor, completa todos los campos antes de continuar.");
        } else {
            // Si todos los campos están llenos,  proceder con la acción deseada

            String cancionNombre = nombreCancion.getText();
            String albumNombre = nombreAlbun.getText();
            String duracionCancion = duracion.getText();
            String generoCancion = genero.getText();
            String urlCancion = url.getText();
            java.time.LocalDate fechaCancion = fecha.getValue();

            URL myUrlCancion = null;
            //Convertir de String a formato URL
            try {
                myUrlCancion = new URL(urlCancion);
            } catch (IOException e) {

                myAlerta("Mal formato de URL");
            }

            myTienda = new TiendaMusica();
            //Nombre de artista a buscar
            String artistaName = artista.getText();
            //Variables auxiliares
            BinaryTree<Artista> treeAxl = myTienda.getArtistas();
            Artista artAXl = new Artista();
            artAXl.setNombre(artistaName);
            //Obtener artista a agregar cancion
            Artista artista1 = treeAxl.ObtenerElemento(artAXl);
            if(artista1!=null){
                Cancion cancion = new Cancion(cancionNombre, albumNombre, duracionCancion, generoCancion, myUrlCancion);

                myTienda.crearCancion(cancion,artista1);
                System.out.println(artista1.toString());


                ListaDobleEnlazada<Cancion> cancionesArtista = new ListaDobleEnlazada<>();

                    cancionesArtista = artista1.getCanciones();
                    System.out.println(cancionesArtista.getSize());

                    for(Cancion cancionShow : cancionesArtista){
                        System.out.println(cancionShow.toString());

                    }



            }else {
                myAlerta("Artista no existe");
            }



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
