package com.tiendamusica.controller;

import com.tiendamusica.Logica.Artista;
import com.tiendamusica.Logica.Cancion;
import com.tiendamusica.Logica.TiendaMusica;
import com.tiendamusica.Testeo.testListaDonleEnlazada;
import com.tiendamusica.myTools.ListaDobleEnlazada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

public class MySongsController implements Initializable {
    @FXML
    private Button bntPlay;
    @FXML
    private TextField txtBuscar;
    @FXML
    private Button btnBuscar;
    @FXML
    private Button btnFav;
    @FXML
    private TableColumn<Cancion, String> columNombre;
    @FXML
    private TableColumn<Cancion, String> columAño;
    @FXML
    private TableColumn<Cancion, String> columURL;
    @FXML
    private TableColumn<Cancion, String> columDuracion;
    @FXML
    private TableView<Cancion> tableCanciones;

    private TiendaMusica tiendaMusica;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configurar las columnas de la tabla
        columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columAño.setCellValueFactory(new PropertyValueFactory<>("year"));
        columURL.setCellValueFactory(new PropertyValueFactory<>("URL"));
        columDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));

        // Obtener la lista de canciones de TiendaMusica
        ObservableList<Cancion> cancionesObservable = FXCollections.observableArrayList();

        // Asumiendo que 'tiendaMusica' es tu instancia de TiendaMusica
        ListaDobleEnlazada<Cancion> listaDobleEnlazada = tiendaMusica.getCanciones();

        // Iterar sobre la lista doblemente enlazada y agregar cada canción a la lista observable
        for (int i = 1; i <= listaDobleEnlazada.getSize(); i++) {
            Cancion cancion = listaDobleEnlazada.getPosition(i);
            cancionesObservable.add(cancion);
        }

        // Asignar la lista observable a la TableView
        tableCanciones.setItems(cancionesObservable);
    }

    @FXML
    void showPlay(ActionEvent event) {

    }

    @FXML
    void showBuscar(ActionEvent event) {

    }

    @FXML
    void showFav(ActionEvent event) {

    }


    @FXML
    void selectedClick(ActionEvent event) {

    }

}
