package com.tiendamusica.Testeo;

import com.tiendamusica.Logica.TiendaMusica;
import com.tiendamusica.Logica.Usuario;

import java.util.HashMap;

public class registerUser {


    public static void main(String[] args) {


        TiendaMusica tienda = new TiendaMusica();

        Usuario user1 = new Usuario("juli","123","omi@gmail.com1");
        Usuario user = new Usuario("omi","1","omi@gmail.com1");

        tienda.registrarUsuario(user);

        tienda.verUsuarios();

        HashMap<String, Usuario> usuarios = tienda.getUsuarios();





        System.out.println(usuarios.size());
    }






}
