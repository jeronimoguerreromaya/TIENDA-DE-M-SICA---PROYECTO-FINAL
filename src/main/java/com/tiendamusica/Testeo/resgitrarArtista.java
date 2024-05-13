package com.tiendamusica.Testeo;

import com.tiendamusica.Logica.Artista;
import com.tiendamusica.Logica.TiendaMusica;
import com.tiendamusica.myTools.BinaryTree;
import com.tiendamusica.myTools.Estado;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class resgitrarArtista {
    public static void main(String[] args) {
        BinaryTree<Artista> a = new BinaryTree<>();
        TiendaMusica my = new TiendaMusica();

        Artista nightwish = new Artista("0000", "Nightwish", "Finlandia", Estado.Banda);
        Artista wizKhalifa = new Artista("0001", "Wiz Khalifa", "US", Estado.Solista);

            //my.crearArtista(nightwish);
            //my.crearArtista(nightwish);

            //nightwish.toString();


        a = my.getArtistas();
        Artista s = new Artista();
            s.setNombre(nightwish.getNombre());
        Artista x = new Artista();

        x = a.ObtenerElemento(s);

        System.out.println(x.toString());


    }
}
