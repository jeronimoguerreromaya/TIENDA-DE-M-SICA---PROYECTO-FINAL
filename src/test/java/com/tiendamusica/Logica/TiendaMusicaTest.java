package com.tiendamusica.Logica;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TiendaMusicaTest {

    @Test
    public void registerUser(){
        TiendaMusica tienda = new TiendaMusica();
        Usuario user = new Usuario();


        user.setUserName("omi");
        user.setContrasena("123");
        user.setGmail("omi@gmail.com");

        tienda.registerUser(user);
    }
  
}