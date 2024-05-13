package com.tiendamusica.myTools;

import java.io.Serializable;

public class BinaryTree<T extends Comparable<T> & Serializable > implements Serializable  {
    Node<T> root;

    public BinaryTree() {
        root = null;
    }

    // Insertar un nuevo nodo en el árbol
    public void insert(T data) {
        root = insertRecursive(root, data);
    }

    Node<T> insertRecursive(Node<T> node, T data) {
        if (node == null) {
            node = new Node<>(data);
            return node;
        }

        if (data.compareTo(node.data) < 0)
            node.left = insertRecursive(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = insertRecursive(node.right, data);

        return node;
    }

    // Búsqueda de un elemento en el árbol
    public boolean search(T data) {
        return searchRecursive(root, data);
    }

    boolean searchRecursive(Node<T> node, T data) {
        if (node == null)
            return false;

        if (node.data.compareTo(data) == 0)
            return true;
        else if (data.compareTo(node.data) < 0)
            return searchRecursive(node.left, data);
        else
            return searchRecursive(node.right, data);
    }

    // Eliminar un elemento del árbol
    public void delete(T data) {
        root = deleteRecursive(root, data);
    }

    Node<T> deleteRecursive(Node<T> node, T data) {
        if (node == null)
            return null;

        if (data.compareTo(node.data) < 0)
            node.left = deleteRecursive(node.left, data);
        else if (data.compareTo(node.data) > 0)
            node.right = deleteRecursive(node.right, data);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            node.data = minValue(node.right);
            node.right = deleteRecursive(node.right, node.data);
        }

        return node;
    }
    // Obtener un elemento del árbol
    public T ObtenerElemento(T data) {
        return ObtenerElementoRecursivo(root, data);
    }

    private T ObtenerElementoRecursivo(Node<T> node, T data) {
        if (node == null) {
            return null; // El elemento no se encuentra en el árbol
        }

        if (data.compareTo(node.data) == 0) {
            return node.data; // Se encontró el elemento
        } else if (data.compareTo(node.data) < 0) {
            return ObtenerElementoRecursivo(node.left, data); // Buscar en el subárbol izquierdo
        } else {
            return ObtenerElementoRecursivo(node.right, data); // Buscar en el subárbol derecho
        }
    }
    // Reemplazar un elemento del árbol
    public boolean RemplazarElemento(T oldData,T newData) {
        return RemplazarElementoRecursivo(root, oldData, newData);
    }

    private boolean RemplazarElementoRecursivo(Node<T> node, T oldData, T newData) {
        if (node == null) {
            return false; // El elemento no se encuentra en el árbol
        }

        if (oldData.compareTo(node.data) == 0) {
            node.data = newData; // Reemplazar el elemento
            return true; // Se reemplazó el elemento
        } else if (oldData.compareTo(node.data) < 0) {
            return RemplazarElementoRecursivo(node.left, oldData, newData); // Buscar en el subárbol izquierdo
        } else {
            return RemplazarElementoRecursivo(node.right, oldData, newData); // Buscar en el subárbol derecho
        }
    }

    T minValue(Node<T> node) {
        T minVal = node.data;
        while (node.left != null) {
            minVal = node.left.data;
            node = node.left;
        }
        return minVal;
    }

    // Imprimir todos los elementos del árbol en orden
    public   void printInOrder() {
        printInOrderRecursive(root);
    }

    void printInOrderRecursive(Node<T> node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.print(node.data + " ");
            printInOrderRecursive(node.right);
        }
    }
}class Node<T extends Comparable<T>> implements Serializable  {
    T data;
    Node<T> left, right;

    Node(T data) {
        this.data = data;
        left = right = null;
    }
}
