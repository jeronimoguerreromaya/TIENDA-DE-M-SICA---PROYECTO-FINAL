package com.tiendamusica.myTools;

import javafx.scene.control.PasswordField;

import java.io.Serializable;
import java.util.Iterator;

public class ListaDobleEnlazada<T  extends Comparable<T> & Serializable> implements Iterable<T> , Serializable {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int size;

    public ListaDobleEnlazada() {
        cabeza = null;
        cola = null;
        size = 0;
    }


    class Nodo<T> implements  Serializable{
        T dato;
        Nodo<T> siguiente;
        Nodo<T> anterior;

        public Nodo(T dato) {
            this.dato = dato;
            siguiente = null;
            anterior = null;
        }
    }


    public void addEnd(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }

        size++;
    }

    public void addBeginning(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }

        size++;
    }
    public boolean buscar(T dato) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return true; // Encontró el dato en la lista
            }
            actual = actual.siguiente;
        }
        return false; // No encontró el dato en la lista
    }

    public void eliminarEnd() {
        if (cabeza == null) {
            return;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.anterior;
            cola.siguiente = null;
        }

        size--;
    }

    public void deletBeginning() {
        if (cabeza == null) {
            return;
        }

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }

        size--;
    }
    public T getPosition(int p){
        if(p<= size && p>=0 && cabeza!=null) {
            Nodo<T> current = cabeza;
            int i= 0;
            while(i!=p-1){
                current = current.siguiente;
                i++;
            }
            return  current.dato;
        }else{
            return null;
        }

    }

    public int getSize() {
        return size;
    }

    public void print() {
        Nodo<T> actual = cabeza;

        while (actual != null) {
            System.out.println(actual.dato + " ");
            actual = actual.siguiente;
        }

        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new ListaIterator();
    }
    private class ListaIterator implements Iterator<T> {
        private Nodo<T> actual;

        public ListaIterator() {
            actual = cabeza;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                System.out.println("No hay elementos en la lista");
            }
            T dato = actual.dato;
            actual = actual.siguiente;
            return dato;
        }
    }}
