package com.tiendamusica.Logica;

public class Administrador {
    private String userName;
    private String contraseña;

    public Administrador(String userName, String contraseña) {
        this.userName = userName;
        this.contraseña = contraseña;
    }

    // Getters y Setters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
