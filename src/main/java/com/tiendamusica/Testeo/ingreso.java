package com.tiendamusica.Testeo;

import com.tiendamusica.Logica.TiendaMusica;

public class ingreso {
    public static void main(String[] args) {
        TiendaMusica tienda = new TiendaMusica();

        String u="omi1";
        String p="1";

       if(tienda.validarIngreso(u,p)){
           System.out.println("ingreso");
       }else{
           System.out.println("Errado");
       }
    }
}
