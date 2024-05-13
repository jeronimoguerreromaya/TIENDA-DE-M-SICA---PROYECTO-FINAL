package com.tiendamusica.myTools;

public class Pila <T>{




    private Nodo<T> head;
    private Nodo<T> end;
    private int size;

    private static class Nodo<T> {
        T data;
        Nodo<T> next;

        Nodo(T data) {
            this.data = data;
            this.next= null;
        }
    }

    public void push(T data) {
        Nodo<T> newNode = new Nodo<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }


    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }


    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return head.data;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int getSize() {
        return size;
    }


    public void clear() {
        head = null;
        size = 0;
    }





}