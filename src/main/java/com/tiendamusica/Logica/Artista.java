package com.tiendamusica.Logica;

public class Artista {
    private String codigo;
    private String nombre;
    private String nacionalidad;
    private Estado estado;
   // private ListaDoblementeEnlazada<Cancion> canciones;

    public Artista(String codigo, String nombre, String nacionalidad, Estado estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.estado = estado;
        //this.canciones = new ListaDoblementeEnlazada<>();
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

    //public ListaDoblementeEnlazada<Cancion> getCanciones() {
        //return canciones;
    //}

    //public void setCanciones(ListaDoblementeEnlazada<Cancion> canciones) {
        //this.canciones = canciones;
    //}
    public enum Estado{
        Solista, Banda
    }
}