package com.tiendamusica.Logica;

import java.io.Serializable;

public class Person implements Serializable {
    private String userName;

    private String password;

    public Person(){

    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
