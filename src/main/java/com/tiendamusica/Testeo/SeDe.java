package com.tiendamusica.Testeo;

import com.tiendamusica.Logica.Administrador;
import com.tiendamusica.Logica.Artista;
import com.tiendamusica.Logica.Cancion;
import com.tiendamusica.Logica.Usuario;
import com.tiendamusica.myTools.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class SeDe {
    public static void main(String[] args) {

        BinaryTree<Artista> x = new BinaryTree<>();
         seserializarBinaryTree(x);



    }
    public static Artista deserializarArt(){//funciona
        Artista artista = new Artista();
        try (FileInputStream fileInputStream = new FileInputStream("src\\main\\java\\Percistencia\\art.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Lee el objeto BinaryTree desde el archivo
            artista = (Artista) objectInputStream.readObject();
        } catch (IOException e) {
            // Manejar la excepción IOException
            System.err.println("Error al deserializar el árbol: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        } catch (ClassNotFoundException e) {
            // Manejar la excepción ClassNotFoundException
            System.err.println("Error de clase no encontrada durante la deserialización: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        }
        return artista;
    }
    public static void seserializarArt(Artista artista){//funciona

        try (FileOutputStream fileOutputStream = new FileOutputStream("src\\main\\java\\Percistencia\\art.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // Escribe el objeto BinaryTree en el archivo
            objectOutputStream.writeObject(artista);
        } catch (IOException e) {
            // Manejar la excepción IOException
            System.err.println("Error al serializar el árbol: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        }
    }

    public static Cancion deserializarCancion(){
       Cancion artista = new Cancion();
        try (FileInputStream fileInputStream = new FileInputStream("src\\main\\java\\Percistencia\\song.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Lee el objeto BinaryTree desde el archivo
            artista = (Cancion) objectInputStream.readObject();
        } catch (IOException e) {
            // Manejar la excepción IOException
            System.err.println("Error al deserializar el árbol: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        } catch (ClassNotFoundException e) {
            // Manejar la excepción ClassNotFoundException
            System.err.println("Error de clase no encontrada durante la deserialización: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        }
        return artista;
    }
    public static void seserializarCancion(Cancion cancion){
        try (FileOutputStream fileOutputStream = new FileOutputStream("src\\main\\java\\Percistencia\\song.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // Escribe el objeto BinaryTree en el archivo
            objectOutputStream.writeObject(cancion);
        } catch (IOException e) {
            // Manejar la excepción IOException
            System.err.println("Error al serializar el árbol: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        }
    }

    public static Usuario deserializarUsuario(){
        Usuario artista = new Usuario();
        try (FileInputStream fileInputStream = new FileInputStream("src\\main\\java\\Percistencia\\urs.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Lee el objeto BinaryTree desde el archivo
            artista = (Usuario) objectInputStream.readObject();
        } catch (IOException e) {
            // Manejar la excepción IOException
            System.err.println("Error al deserializar el árbol: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        } catch (ClassNotFoundException e) {
            // Manejar la excepción ClassNotFoundException
            System.err.println("Error de clase no encontrada durante la deserialización: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        }
        return artista;
    }
    public static void seserializarUsuario(Usuario cancion){

        try (FileOutputStream fileOutputStream = new FileOutputStream("src\\main\\java\\Percistencia\\urs.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // Escribe el objeto BinaryTree en el archivo
            objectOutputStream.writeObject(cancion);
        } catch (IOException e) {
            // Manejar la excepción IOException
            System.err.println("Error al serializar el árbol: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        }
    }

    public static BinaryTree<Artista> deserializarBinaryTree(){
        BinaryTree<Artista> tree = new BinaryTree<>();
        try (FileInputStream fileInputStream = new FileInputStream("src\\main\\java\\Percistencia\\bn1.txt");
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
    public static void seserializarBinaryTree(BinaryTree<Artista> tree){
        try (FileOutputStream fileOutputStream = new FileOutputStream("src\\main\\java\\Percistencia\\ArbolArt1.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // Escribe el objeto BinaryTree en el archivo
            objectOutputStream.writeObject(tree);
        } catch (IOException e) {
            // Manejar la excepción IOException
            System.err.println("Error al serializar el árbol: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        }
    }

    public static ListaCircular<String> deserializarListaCircular(){
        ListaCircular<String> tree = new ListaCircular<>();
        try (FileInputStream fileInputStream = new FileInputStream("src\\main\\java\\Percistencia\\lc.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Lee el objeto BinaryTree desde el archivo
            tree = ( ListaCircular<String>) objectInputStream.readObject();
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
    public static void seserializarListaCircular( ListaCircular<String> tree){
        try (FileOutputStream fileOutputStream = new FileOutputStream("src\\main\\java\\Percistencia\\lc.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // Escribe el objeto BinaryTree en el archivo
            objectOutputStream.writeObject(tree);
        } catch (IOException e) {
            // Manejar la excepción IOException
            System.err.println("Error al serializar el árbol: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        }
    }

    public static ListaDobleEnlazada<String> deserializarListaDobleEnlazada(){
        ListaDobleEnlazada<String> tree = new ListaDobleEnlazada<>();
        try (FileInputStream fileInputStream = new FileInputStream("src\\main\\java\\Percistencia\\le.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            // Lee el objeto BinaryTree desde el archivo
            tree = ( ListaDobleEnlazada<String>) objectInputStream.readObject();
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
    public static void seserializarListaDobleEnlazada(ListaDobleEnlazada<String> tree){
        try (FileOutputStream fileOutputStream = new FileOutputStream("src\\main\\java\\Percistencia\\le.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            // Escribe el objeto BinaryTree en el archivo
            objectOutputStream.writeObject(tree);
        } catch (IOException e) {
            // Manejar la excepción IOException
            System.err.println("Error al serializar el árbol: " + e.getMessage());
            // Puedes agregar cualquier otra lógica de manejo de errores aquí
        }
    }



}
