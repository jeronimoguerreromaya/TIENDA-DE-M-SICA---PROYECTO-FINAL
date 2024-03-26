package com.tiendamusica.Logica;

//Objecto Usuario


import java.io.Serializable;

public class Usuario implements Serializable {
    private String userName;
    private String contrasena;
    private String gmail;
    //private ListaCircular<Cancion> misCanciones;


    public Usuario(){

    }
    public Usuario(String userName, String contrasena, String gmail) {
        this.userName = userName;
        this.contrasena = contrasena;
        this.gmail = gmail;
        //this.misCanciones = new ListaCircular<>();
    }

        // Guardar cancion en lista de canciones del usuario
        public void guardar() {

        }

        // Eliminar cancion en lista de canciones del usuario
        public void eliminar() {

        }

        // Deshacer la última acción realizada en la lista de canciones
        public void deshacer() {

        }

        // Rehacer la última acción realizada en la lista de canciones
        public void rehacer() {

        }

        // Ordenar las canciones de la lista de canciones del usuario
        public void ordenar() {

        }

    // Getters y Setters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    //public ListaCircular<Cancion> getMisCanciones() {
       // return misCanciones;
    //}

    //public void setMisCanciones(ListaCircular<Cancion> misCanciones) {
        //this.misCanciones = misCanciones;
   // }
    //Metodo para imprimir en consola los atributos de usuario
    @Override
    public String toString() {
        return "Usuario{" +
                "userName='" + userName + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", gmail='" + gmail + '\'' +
                '}';
    }
}


