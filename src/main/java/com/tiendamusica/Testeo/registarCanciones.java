package com.tiendamusica.Testeo;

import com.tiendamusica.Logica.Artista;
import com.tiendamusica.Logica.Cancion;
import com.tiendamusica.Logica.TiendaMusica;
import com.tiendamusica.myTools.BinaryTree;
import com.tiendamusica.myTools.Estado;
import com.tiendamusica.myTools.ListaDobleEnlazada;

public class registarCanciones {
    public static void main(String[] args) {

        BinaryTree<Artista> a = new BinaryTree<>();
        TiendaMusica my = new TiendaMusica();

        Artista nightwish = new Artista("0000", "Nightwish", "Finlandia", Estado.Banda);
        Artista wizKhalifa = new Artista("0001", "Wiz Khalifa", "US", Estado.Solista);
        Cancion c1 = new Cancion();
        Cancion c2 = new Cancion();
            c1.setNombre("nemo");


        //my.crearCancion(c1, nightwish);
    //    my.crearCancion(c1, nightwish);

        a = my.getArtistas();
        ListaDobleEnlazada<Cancion> c = new ListaDobleEnlazada<>();
        Artista s = new Artista();
        s.setNombre(wizKhalifa.getNombre());
        Artista x = new Artista();
        if(a.search(s)){
            x = a.ObtenerElemento(s);
            c = x.getCanciones();
            System.out.println(c.getSize());

            for(Cancion cancion : c){
                System.out.println(cancion.toString());

            }

        }else {
            System.out.println("No se encotro artista");
        }



    }
}
