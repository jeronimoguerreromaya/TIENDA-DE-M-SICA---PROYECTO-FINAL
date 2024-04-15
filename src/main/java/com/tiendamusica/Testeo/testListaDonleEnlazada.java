package com.tiendamusica.Testeo;

import com.tiendamusica.myTools.ListaDobleEnlazada;

public class testListaDonleEnlazada {
    public static void main(String[] args) {
        ListaDobleEnlazada<String> l = new ListaDobleEnlazada();

        l.addBeginning("jero");
        l.addEnd("norman");
        l.addEnd("sara");
        l.addEnd("aleja");
        l.addEnd("juli");

    }

}
