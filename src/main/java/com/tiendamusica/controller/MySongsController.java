package com.tiendamusica.controller;

import com.tiendamusica.Logica.Artista;
import com.tiendamusica.Logica.Cancion;
import com.tiendamusica.Logica.TiendaMusica;
import com.tiendamusica.Testeo.testListaDonleEnlazada;
import com.tiendamusica.myTools.ListaDobleEnlazada;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Stack;

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
    private Button bntDesahacer;
    @FXML
    private Button bntEliminar;
    @FXML
    private TableColumn<Cancion, String> columNombre;
    @FXML
    private TableColumn<Cancion, String> columNombreAlbum;
    @FXML
    private TableColumn<Cancion, String> columURL;
    @FXML
    private TableColumn<Cancion, String> columDuracion;
    @FXML
    private TableView<Cancion> tableCanciones;
    private ObservableList<Cancion> canciones;
    private ObservableList<Cancion> favoritos;
    private Stack<Cancion> cancionesEliminadas = new Stack<>();
    private TiendaMusica tiendaMusica;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            canciones = FXCollections.observableArrayList(
                    new Cancion("Soy Yo", "Neutro Shorty", "4:33", "trap", new URL("https://www.youtube.com/watch?v=nPkQH8-cnpo")),
                    new Cancion("Mundo de lo Ajeno", "Akapellah ft. Pirlo", "3:22", "trap", new URL("https://www.youtube.com/watch?v=mRBdIZ04jMk"))
                    );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        favoritos = FXCollections.observableArrayList(); // Initialize the favorites list
        tableCanciones.setItems(canciones);

/**
        // Obtener la lista de canciones desde TiendaMusica
        ListaDobleEnlazada<Cancion> canciones = TiendaMusica.obtenerCanciones();

        // Crear una lista observable para la tabla
        ObservableList<Cancion> observableCanciones = FXCollections.observableArrayList();

        // Agregar todas las canciones a la lista observable
        for (int i = 0; i < canciones.getSize(); i++) {
            observableCanciones.add(canciones.getPosition(i));
        }**/
        // Configurar las columnas de la tabla
        this.columNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columNombreAlbum.setCellValueFactory(new PropertyValueFactory<>("nombreAlbum"));
        this.columURL.setCellValueFactory(new PropertyValueFactory<>("url"));
        this.columDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));

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
    void showFav(ActionEvent event) {
        Cancion selectedCancion = tableCanciones.getSelectionModel().getSelectedItem();
        if (selectedCancion != null && !favoritos.contains(selectedCancion)) {
            favoritos.add(selectedCancion);
            // Actualizar la tabla en el controlador FavController
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tiendamusica/app/interfaces/Fav-view.fxml"));
            try {
                Parent root = loader.load();
                FavController favoritesController = loader.getController();
                favoritesController.setFavoritos(favoritos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            TiendaMusica.mostrarMensaje("Información", null, "La canción ya está en la lista de favoritos o no se seleccionó ninguna canción.", Alert.AlertType.INFORMATION);
        }
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
}
