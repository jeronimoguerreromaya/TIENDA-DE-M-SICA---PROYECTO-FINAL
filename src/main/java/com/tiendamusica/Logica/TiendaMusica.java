package com.tiendamusica.Logica;

import com.tiendamusica.myTools.BinaryTree;
import com.tiendamusica.myTools.ListaDobleEnlazada;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.attribute.UserPrincipal;
import java.util.Date;
import java.util.HashMap;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TiendaMusica {



    private HashMap<String, Usuario> usuarios = new HashMap<>();



    private  BinaryTree<Artista> artistas = new BinaryTree<>();




    private Administrador admin ;


    public TiendaMusica(){
      //Inicializar el mapa de usuarios con los guardados en memeoria
        this.usuarios=deserializarUsuario();
        this.artistas = deserializeBinaryTree("src\\main\\java\\Percistencia\\Artistas.txt");
    }
    public BinaryTree<Artista> crearArtista (Artista artista){



        if (artistas.search(artista)) {
            // Si el artista ya existe en el árbol, no se agrega
            System.out.println("Usuario ya existe");

        } else {
            // Si el artista no existe, se agrega al árbol
            artistas.insert(artista);
            serializarArtista(artistas);
            System.out.println("Usuario agregado");

        }
        return  artistas;
    }
    public  void crearCancion(Cancion cancion ,Artista artista){
        if(validarCancion(cancion.getNombre(), cancion.getNombreAlbum())){
            //agregar codigo a la cancion
          //  cancion.setCode(generarCodigo());
            //Agregar cancion a artista
        }else{
            System.out.println("cancion ya exist");
        }

    }
    //Genera codigo unico  de una cancin nueva cancion
    public  void generarCodigo(){

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
    }public  void serializarArtista (BinaryTree<Artista> artistas){

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src\\main\\java\\Percistencia\\Artistas1.txt"));
            os.writeObject(artistas);
            os.flush();
            os.close();
        }catch (IOException e){

        }
    }

    public void serializeBinaryTree(BinaryTree<Artista> tree, String filename) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filename);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // Escribe el objeto BinaryTree en el archivo
            objectOutputStream.writeObject(tree);
        } catch (IOException e) {
            // Manejar la excepción IOException
            System.err.println("Error al serializar el árbol: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        }
    }
    public BinaryTree<Artista> deserializeBinaryTree(String filename) {
        BinaryTree<Artista> tree = null;
        try (FileInputStream fileInputStream = new FileInputStream(filename);
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
        return artistas;
    }

}
