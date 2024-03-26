package com.tiendamusica.Logica;

import java.io.*;
import java.util.HashMap;

public class TiendaMusica {



    private HashMap<String, Usuario> usuarios;



    public TiendaMusica(){

    }

    public void registrarUsuario(Usuario user){

        usuarios = deserializarUsuario();
        if(validarUsuario(user.getUserName())){

            usuarios.put(user.getUserName(),user);
            serializarUsuario();
            System.out.println("Usuario registrado correctamente");

        }else {

            System.out.println("Usuario ya existe ");
        }
    }
    public void serializarUsuario() {
        try {
            FileOutputStream fileOut = new FileOutputStream("src\\main\\java\\Percistencia\\usuarios.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(usuarios);
            out.close();
            fileOut.close();
            System.out.println("Usuarios serializados correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String,Usuario> deserializarUsuario() {
        try {
            FileInputStream fileIn = new FileInputStream("src\\main\\java\\Percistencia\\usuarios.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            HashMap<String,Usuario>  usuarios = (HashMap<String, Usuario>) in.readObject();
            in.close();
            fileIn.close();
           // System.out.println("Usuarios deserializados correctamente.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    public boolean validarUsuario(String key){
        usuarios = deserializarUsuario();

        return usuarios.containsKey(key);
    }


    //Getter y Setters
    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(HashMap<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }




}
