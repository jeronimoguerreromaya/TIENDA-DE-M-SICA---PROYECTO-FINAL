package com.tiendamusica.Logica;

import com.tiendamusica.myTools.Genero;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.net.URL;
import java.util.Comparator;
import java.util.Date;

public class Cancion implements Comparable<Cancion>, Serializable {
    private String code;
    private String nombre;
    private String nombreAlbum;
    private BufferedImage caratula;
    private Date year;
    private float duracion;
    private Genero genero;
    private URL url;

    public Cancion(String nombre, String nombreAlbum, BufferedImage caratula, Date year, float duracion, Genero genero, URL url) {
        this.nombre = nombre;
        this.nombreAlbum = nombreAlbum;
        this.caratula = caratula;
        this.year = year;
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

    public BufferedImage getCaratula() {
        return caratula;
    }

    public void setCaratula(BufferedImage caratula) {
        this.caratula = caratula;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date ano) {
        this.year = year;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public int compareTo(Cancion o) {
        return 0;
    }


}
