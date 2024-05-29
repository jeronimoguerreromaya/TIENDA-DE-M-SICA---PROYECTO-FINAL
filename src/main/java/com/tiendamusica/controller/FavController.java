package com.tiendamusica.controller;

import com.tiendamusica.Logica.Cancion;
import com.tiendamusica.Logica.TiendaMusica;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

public class FavController implements Initializable {
    @FXML
    private Button bntEliminar;
    @FXML
    private Button bntDesahacer;
    @FXML
    private Button bntPlay;
    @FXML
    private TextField txtBuscar;
    @FXML
    private Button btnBuscar;
    @FXML
    private TableColumn<Cancion, String> columNombre;
    @FXML
    private TableColumn<Cancion, String> columURL;
    @FXML
    private TableColumn<Cancion, String> columDuracion;
    @FXML
    private TableView<Cancion> tableCanciones;
    @FXML
    private TableColumn<Cancion, String> tableNombreAlbum;
    private ObservableList<Cancion> canciones;
    private Stack<Cancion> cancionesEliminadas = new Stack<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.canciones = FXCollections.observableArrayList();
        // Configurar las columnas de la tabla
        columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableNombreAlbum.setCellValueFactory(new PropertyValueFactory<>("nombreAlbum"));
        columURL.setCellValueFactory(new PropertyValueFactory<>("url"));
        columDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
    }

    @FXML
    void showPlay(ActionEvent event) {
        Cancion selectedCancion = tableCanciones.getSelectionModel().getSelectedItem();
        if (selectedCancion != null) {
            try {
                // Obtener la URL de la canción seleccionada
                String url = selectedCancion.getUrl().toString();

                // Abrir la URL en el navegador web predeterminado
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            // Si no se selecciona ninguna canción, mostrar un mensaje de alerta
            TiendaMusica.mostrarMensaje("Información", null, "Seleccione una canción para reproducir.", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    void showBuscar(ActionEvent event) {
        String criterioBusqueda = txtBuscar.getText().toLowerCase(); // Obtener el criterio de búsqueda ingresado por el usuario
        FilteredList<Cancion> cancionesFiltradas = new FilteredList<>(canciones);

        // Filtrar las canciones según el criterio de búsqueda
        cancionesFiltradas.setPredicate(cancion -> {
            if (criterioBusqueda == null || criterioBusqueda.isEmpty()) {
                return true; // Mostrar todas las canciones si el campo de búsqueda está vacío
            }
            // Verificar si el nombre de la canción, el nombre del álbum o la duración coinciden con el criterio de búsqueda
            return cancion.getNombre().toLowerCase().contains(criterioBusqueda)
                    || cancion.getNombreAlbum().toLowerCase().contains(criterioBusqueda)
                    || cancion.getDuracion().toLowerCase().contains(criterioBusqueda);
        });
        // Actualizar la tabla con las canciones filtradas
        tableCanciones.setItems(cancionesFiltradas);
    }

    @FXML
    void showEliminar(ActionEvent event) {
        Cancion selectedCancion = tableCanciones.getSelectionModel().getSelectedItem();
        if (selectedCancion != null) {
            canciones.remove(selectedCancion); // Elimina la canción seleccionada de la lista de canciones
            cancionesEliminadas.push(selectedCancion); // Agrega la canción eliminada a la pila
        } else {
            TiendaMusica.mostrarMensaje("Información", null, "No se ha seleccionado ninguna canción para eliminar.", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    void showDesahacer(ActionEvent event) {
        if (!cancionesEliminadas.isEmpty()) {
            Cancion ultimaCancionEliminada = cancionesEliminadas.pop(); // Obtener la última canción eliminada de la pila
            canciones.add(ultimaCancionEliminada); // Agregar la canción de vuelta a la lista de canciones
        } else {
            TiendaMusica.mostrarMensaje("Información", null, "No hay acciones para deshacer.", Alert.AlertType.INFORMATION);
        }
    }

    public void setFavoritos(ObservableList<Cancion> canciones) {
        if (this.canciones != null) {
            this.canciones.setAll(canciones);
        }
        this.canciones.setAll(canciones);
        tableCanciones.setItems(this.canciones);
    }

}

