package com.tiendamusica.myTools;

import java.io.Serializable;
import java.util.Iterator;

public class ListaCircular<T  extends Comparable<T> & Serializable> implements Iterable<T>, Serializable {


    // Clase interna Nodo
        private class Nodo implements  Serializable{
            T data;
            Nodo next;

            Nodo(T data) {
                this.data = data;
                this.next = null;
            }
        }

        // Cabeza de la lista
        private Nodo head;
        private int size;

        // Constructor
        public ListaCircular() {
            head = null;
            size = 0;
        }

        // Método para insertar un elemento al final de la lista
        public void insertar(T data) {
            Nodo nuevoNodo = new Nodo(data);

            if (head == null) {
                head = nuevoNodo;
                head.next = head; // Apunta a sí mismo, formando un círculo
            } else {
                Nodo temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = nuevoNodo;
                nuevoNodo.next = head;
            }
            size++;
        }

        // Método para eliminar un elemento de la lista
        public void eliminar(T data) {
            if (head == null) {
                return;
            }

            Nodo current = head;
            Nodo previous = null;

            // Busca el nodo a eliminar
            do {
                if (current.data.equals(data)) {
                    if (current == head) {
                        if (head.next == head) {
                            // Solo hay un nodo en la lista
                            head = null;
                        } else {
                            Nodo temp = head;
                            while (temp.next != head) {
                                temp = temp.next;
                            }
                            head = head.next;
                            temp.next = head;
                        }
                    } else {
                        previous.next = current.next;
                    }
                    size--;
                    return;
                }
                previous = current;
                current = current.next;
            } while (current != head);
        }

        // Método para obtener un elemento en la posición específica
        public T obtener(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Índice fuera de rango");
            }

            Nodo current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        // Método para imprimir la lista circular
        public void imprimir() {
            if (head == null) {
                System.out.println("La lista está vacía.");
                return;
            }

            Nodo current = head;
            do {
                System.out.print(current.data + " -> ");
                current = current.next;
            } while (current != head);
            System.out.println("(vuelve al principio)");
        }

        // Método para obtener el tamaño de la lista
        public int tamaño() {
            return size;
        }

    @Override
    public Iterator<T> iterator() {
        return new ListaCircularIterator();
    }

    private class ListaCircularIterator implements Iterator<T> {
        private Nodo current;

        public ListaCircularIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            if (head == null) {
                return false;
            }
            if (current.next == head) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                System.out.println("No hay más elementos en la lista");
                return null;
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
