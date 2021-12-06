package io.example.algos.ds;

import java.util.Objects;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    private int size;

    public BinarySearchTree() {
    }

    public void add(E element) {
        if (Objects.isNull(root)) {
            root = new Node<>(element);
        } else {
            insertNode(element);
        }
        size++;
    }

    public void remove(E e) {

    }

    public int getSize() {
        return size;
    }

    private Node<E> getOpNode(E e) {
        if (Objects.isNull(root)) {
            throw new RuntimeException("Root cannot be empty");
        }
        Node<E> opNode = null;
        Node<E> node = root;

        while (Objects.nonNull(node)) {
            opNode = node;
            node = e.compareTo(node.element) < 0 ? node.left : node.right;
        }
        return opNode;
    }

    private void insertNode(E e) {
        Node<E> node = root;
        Node<E> iNode = root;
        while (Objects.nonNull(node)) {
            iNode = node;
            if (e.compareTo(node.element) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (e.compareTo(iNode.element) < 0) {
            iNode.left = new Node(e);
        } else {
            iNode.right = new Node(e);
        }
    }

    private class Node<E> {
        E element;
        Node left, right;

        public Node(E element) {
            this.element = element;
            left = right = null;
        }

        public Node(E element, Node left, Node right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
