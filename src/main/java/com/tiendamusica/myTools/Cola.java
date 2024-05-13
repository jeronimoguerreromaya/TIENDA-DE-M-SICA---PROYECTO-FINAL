package com.tiendamusica.myTools;

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int size;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            siguiente = null;
        }
    }

    public Cola() {
        frente = null;
        fin = null;
        size= 0;
    }




    public void encolar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);

        if (colaVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }

        size++;
    }


    public T desencolar() {
        if (colaVacia()) {
            System.out.println("La cola está vacía.");
            return null;
        }

        T dato = frente.dato;
        frente = frente.siguiente;
        size--;

        if (colaVacia()) {
            fin = null;
        }

        return dato;
    }


    public boolean colaVacia() {
        return frente == null;
    }


    public boolean colaLlena() {
        return false;
    }


    public T frente() {
        if (colaVacia()) {
            System.out.println("La cola está vacía.");
            return null;
        }

        return frente.dato;
    }


    public int getSize() {
        return size;
    }
}