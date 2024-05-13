package com.tiendamusica.Logica;

import com.tiendamusica.myTools.Estado;
import com.tiendamusica.myTools.ListaDobleEnlazada;
import javafx.scene.control.Alert;

import java.io.Serializable;

public class Artista implements Serializable, Comparable<Artista> {
    private String codigo;
    private String nombre;
    private String nacionalidad;
    private Estado estado;
   private ListaDobleEnlazada<Cancion> canciones;

    public Artista(String codigo, String nombre, String nacionalidad, Estado estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.estado = estado;
        this.canciones = new ListaDobleEnlazada();
    }
    public Artista(){ this.canciones = new ListaDobleEnlazada();}

    public void agregarCancion (Cancion cancion){
        if(verificarExistenciaCancion(cancion)){
            System.out.println("Artista ya existen en Artista");
        }else{
            canciones.addEnd(cancion);
            System.out.println("se agrego nueva cancion a Artista : " + nombre);
        }
    }
    public boolean verificarExistenciaCancion (Cancion cancion){
        return canciones.buscar(cancion);
    }

    // Getters y Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public ListaDobleEnlazada <Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ListaDobleEnlazada <Cancion> canciones) {
        this.canciones = canciones;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código: ").append(codigo).append("\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Nacionalidad: ").append(nacionalidad).append("\n");
        sb.append("Estado: ").append(estado).append("\n");
        sb.append("Canciones:\n");
        for (Cancion cancion : canciones) {
            cancion.toString();
        }
        return sb.toString();
    }
    @Override
    public int compareTo(Artista o) {
        return nombre.compareTo(o.nombre);

    }


}