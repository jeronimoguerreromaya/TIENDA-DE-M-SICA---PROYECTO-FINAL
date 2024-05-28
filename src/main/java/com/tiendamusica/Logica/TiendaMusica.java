package com.tiendamusica.Logica;

import com.tiendamusica.exceptions.AtributoVacioException;
import com.tiendamusica.myTools.BinaryTree;
import com.tiendamusica.myTools.ListaDobleEnlazada;
import javafx.scene.control.Alert;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TiendaMusica {
    private HashMap<String, Usuario> usuarios = new HashMap<>();
    private BinaryTree<Artista> artistas = new BinaryTree<>();
    private Administrador admin;
    private static ListaDobleEnlazada<Cancion> canciones;


    public TiendaMusica(){
      //Inicializar el mapa de usuarios con los guardados en memeoria
        this.usuarios=deserializarUsuario();
        this.artistas = deserializeBinaryTree();
        this.canciones = new ListaDobleEnlazada();
    }
    public  void crearCancion(Cancion cancion, Artista artista1){
            //agregar codigo a la cancion
            String codigo = generarCodigo();
            cancion.setCode(codigo);
            artista1.agregarCancion(cancion);
            artistas.RemplazarElemento(artista1,artista1);
            serializeBinaryTree(artistas);
    }
    //Genera codigo unico  de una cancin nueva cancion
    public  String generarCodigo(){
        int min = 100000;
        int max = 999999;
        int rango = max - min + 1;
        int numeroAleatorio = (int) (Math.random() * rango) + min;
        return Integer.toString(numeroAleatorio);
     }

    public void crearArtista (Artista artista){
        if (artistas.search(artista)) {
            // Si el artista ya existe en el árbol, no se agrega
            System.out.println("Artista ya existe");
        } else {
            // Si el artista no existe, se agrega al árbol
            artistas.insert(artista);
            serializeBinaryTree(artistas);
            System.out.println("Artista agregado");
        }
    }

    //Metodo registrar usuario
    public  HashMap<String,Usuario> registrarUsuario(Usuario user){
        if(!validarUsuario(user.getUserName())){
            usuarios.put(user.getUserName(),user);
            serializarUsuario(usuarios);
            usuarios = deserializarUsuario();
            System.out.println("Usuario registrado correctamente");
        }else {
            System.out.println("Usuario ya existe ");
        }
        return usuarios;
    }
    //Metodos  de deserializar y serializar
    public  void serializarUsuario (HashMap<String,Usuario> usuarios){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\Percistencia\\usuarios.txt"));
            os.writeObject(usuarios);
            os.flush();
            os.close();
        }catch (IOException e){
        }
    }
    public  HashMap<String,Usuario> deserializarUsuario (){
        HashMap<String, Usuario> usuarios = new HashMap<>();
        try{
            ObjectInputStream os = new ObjectInputStream(new FileInputStream("src\\main\\java\\Percistencia\\usuarios.txt"));
            usuarios=(HashMap<String, Usuario>) os.readObject();
        }catch (IOException | ClassNotFoundException e){
        }
        return usuarios;
    }
    public  void serializarArtista (BinaryTree<Artista> artistas){
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\Percistencia\\Artistas1.txt"));
            os.writeObject(artistas);
            os.flush();
            os.close();
        }catch (IOException e){
        }
    }

    public void serializeBinaryTree(BinaryTree<Artista> tree) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("src\\main\\java\\Percistencia\\Artistas.xml");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // Escribe el objeto BinaryTree en el archivo
            objectOutputStream.writeObject(tree);
        } catch (IOException e) {
            // Manejar la excepción IOException
            System.err.println("Error al serializar el árbol: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        }
    }
    public BinaryTree<Artista> deserializeBinaryTree() {
        BinaryTree<Artista> tree = new BinaryTree<>();
        try (FileInputStream fileInputStream = new FileInputStream("src\\main\\java\\Percistencia\\Artistas.xml");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Lee el objeto BinaryTree desde el archivo
            tree = (BinaryTree<Artista>) objectInputStream.readObject();
        } catch (IOException e) {
            // Manejar la excepción IOException
            System.err.println("Error al deserializar el árbol: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        } catch (ClassNotFoundException e) {
            // Manejar la excepción ClassNotFoundException
            System.err.println("Error de clase no encontrada durante la deserialización: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        }
        return tree;
    }

    //Valida si los datos ingresados son valido para el inicio de sesion
    public boolean validarIngreso(String user,String password){
        if (validarUsuario(user)) {
            //variable usuario auxiliar
            Usuario u = usuarios.get(user);
            //validar contraseña
            if (u.getContrasena().equals(password)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    //Valida si ya existe un usuario con el mismo username
    public boolean validarUsuario(String key){return usuarios.containsKey(key);}
    //Valida si ya existe un cancion igual
    public boolean validarCancion(String name, String albun){
        //Varables auxiliar
        boolean flag = false;
        Cancion cancion = new Cancion();
        ListaDobleEnlazada<Cancion> l = null;
        //recorrer Lista
        for(int i=1; i<=l.getSize(); i++){
            cancion = l.getPosition(i);
            //comparar si la cancion existe
            if (cancion.getNombre().equals(name) && cancion.getNombreAlbum().equals(albun)) {
                return flag;
            }
        }
        return flag;
    }

    //Imprime a los usuario en consola
    public  void verUsuarios(){
        for (HashMap.Entry<String, Usuario> entry : usuarios.entrySet()) {
            String clave = entry.getKey();
            Usuario usuario = entry.getValue();
            System.out.println(clave + " : " + usuario.toString());
        }
    }

    //serializacion de lista de canciones
    public static void serializarCanciones() {
        try {
            // Crear un ObjectOutputStream para escribir en el archivo
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\Persistencia\\canciones.ser"));
            // Serializar la lista de canciones y escribirla en el archivo
            outputStream.writeObject(canciones);
            // Cerrar el stream
            outputStream.close();
            System.out.println("Las canciones han sido serializadas exitosamente.");
        } catch (IOException e) {
            // Manejar la excepción en caso de error durante la escritura
            System.err.println("Error al serializar las canciones: " + e.getMessage());
        }
    }
    public void deserializarCancion() {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("ruta/al/archivo/canciones.ser"));
            ListaDobleEnlazada<Cancion> cancionesDeserializadas = (ListaDobleEnlazada<Cancion>) inputStream.readObject();
            inputStream.close();
            System.out.println("Canciones deserializadas con éxito.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar las canciones: " + e.getMessage());
        }
    }

    //metodo para mostrar mensajes de error
    public static void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    //metodo para agragar canciones a la lista proncipal
    public static void agregarCancion(String nombre, String nombreAlbum, String duracion, String genero, URL url) throws AtributoVacioException {
        if(nombre == null || nombre.isBlank()){
            System.out.print("nombre");
            throw new AtributoVacioException("el nombre es obligatoria");
        }
        if(nombreAlbum == null || nombreAlbum.isBlank()){
            System.out.print("nombre album");
            throw new AtributoVacioException("el nombre de album es obligatoria");
        }
        if(duracion == null || duracion.isBlank()){
            System.out.print("duracion");
            throw new AtributoVacioException("La duracion es obligatoria");
        }
        if(genero == null || genero.isBlank()){
            System.out.print("genero");
            throw new AtributoVacioException("el genero es obligatoria");
        }
        if(url == null ){
            System.out.print("url");
            throw new AtributoVacioException("la url es obligatoria");
        }
        Cancion nuevaCancion = new Cancion(nombre, nombreAlbum, duracion, genero, url);
        canciones.addEnd(nuevaCancion);
        // Llamar al método para serializar las canciones después de agregar una nueva
        serializarCanciones();
        System.out.println("Canción agregada: " + nuevaCancion.getNombre());
    }


    //metodo para eliminar la cancion





    //Getter y Setters
    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(HashMap<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public Administrador getAdmin() {
        return admin = new Administrador();
    }
    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }
    public BinaryTree<Artista> getArtistas() {
        return deserializeBinaryTree();
    }
    public ListaDobleEnlazada<Cancion> getCanciones() { return canciones; }
    public void setCanciones(ListaDobleEnlazada<Cancion> canciones) { this.canciones = canciones; }
}
