package com.tiendamusica.myTools;

class BinaryTree<T extends Comparable<T>> {
    Node<T> root;

    BinaryTree() {
        root = null;
    }

    // Insertar un nuevo nodo en el árbol
    void insert(T data) {
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
    boolean search(T data) {
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
    void delete(T data) {
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

    T minValue(Node<T> node) {
        T minVal = node.data;
        while (node.left != null) {
            minVal = node.left.data;
            node = node.left;
        }
        return minVal;
    }

    // Imprimir todos los elementos del árbol en orden
    void printInOrder() {
        printInOrderRecursive(root);
    }

    void printInOrderRecursive(Node<T> node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.print(node.data + " ");
            printInOrderRecursive(node.right);
        }
    }
}class Node<T extends Comparable<T>> {
    T data;
    Node<T> left, right;

    Node(T data) {
        this.data = data;
        left = right = null;
    }
}
