package com.tiendamusica.Logica;

public class Administrador {
    private String userName;
    private String password;

    public Administrador() {
        this.userName = "admin";
        this.password = "1";
    }

    //validar si credenciales de admnistrador
    public  boolean esAdministrador(String userName,String paswword){

        return this.userName.equals(userName)&&this.password.equals(password);
    }

    // Getters y Setters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
