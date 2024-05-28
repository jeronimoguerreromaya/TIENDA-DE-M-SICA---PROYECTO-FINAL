package com.tiendamusica.Logica;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;

public class Cancion implements Comparable<Cancion>, Serializable {
    private String code;
    private String nombre;
    private String nombreAlbum;
    private Date year;
    private String duracion;
    private String genero;
    private URL url;

    public Cancion(String nombre, String nombreAlbum,  String duracion, String genero, URL url) {
        this.nombre = nombre;
        this.nombreAlbum = nombreAlbum;
        this.duracion = duracion;
        this.genero = genero;
        this.url = url;
    }
    public Cancion(){}

    // Getters y Setters
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombreAlbum() {
        return nombreAlbum;
    }
    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }
    public Date getYear() {
        return year;
    }
    public void setYear(Date ano) {
        this.year = year;
    }
    public String getDuracion() {
        return duracion;
    }
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    @Override
    public String toString() {
        return "Cancion{" +
                "code='" + code + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nombreAlbum='" + nombreAlbum + '\'' +
                ", year=" + year +
                ", duracion='" + duracion + '\'' +
                ", genero='" + genero + '\'' +
                ", url=" + url +
                '}';
    }

    @Override
    public int compareTo(Cancion o) {
        return 0;
    }
}
