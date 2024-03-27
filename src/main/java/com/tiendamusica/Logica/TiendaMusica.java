package com.tiendamusica.Logica;

import java.io.*;
import java.nio.file.attribute.UserPrincipal;
import java.util.HashMap;

public class TiendaMusica {



    private HashMap<String, Usuario> usuarios = new HashMap<>();



    public TiendaMusica(){
      //Inicializar el mapa de usuarios con los guardados en memeoria
        this.usuarios=deserializarUsuario();


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
    //Metodos  de deserializar y serializar un HasMap de usuarios
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




}
