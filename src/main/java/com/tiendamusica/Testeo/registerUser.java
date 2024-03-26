package com.tiendamusica.Testeo;

import com.tiendamusica.Logica.TiendaMusica;
import com.tiendamusica.Logica.Usuario;

import java.util.HashMap;

public class registerUser {


    public static void main(String[] args) {


        TiendaMusica tienda = new TiendaMusica();

        Usuario user = new Usuario("omi","123","omi@gmail.com");

        tienda.registrarUsuario(user);
    }






}
