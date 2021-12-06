package io.example.algos.ds;

import java.util.Objects;

public class LinkedList<T> {
    private Node start = null;
    private Node end = null;
    private int size = 0;

    public long size() {
        return size;
    }

    public void add(T e) {
        add(size, e);
    }

    public void add(int index, T e) {
        ensureIndex(index);
        if (index == 0) {
            linkStart(e);
        } else if (index == size) {
            linkEnd(e);
        } else {
            linkNode(index, e);
        }
    }

    private void linkNode(int index, T e) {
        Node n = getNode(index);
        Node node = new Node(e, n.prev, n);

        node.prev.next = node;
        node.next.prev = node;
    }

    private void linkStart(T e) {
        if (Objects.isNull(start)) {
            start = end = new Node(e, null, null);
        } else {
            start.prev = new Node(e, null, start);
            start = start.prev;
        }
        size++;
    }

    private void linkEnd(T e) {
        end.next = new Node(e, end, null);
        end = end.next;
        size++;
    }

    private Node getNode(int index) {
        Node node = start;
        int c = 0;
        while (Objects.nonNull(node)) {
            if (index == c) {
                break;
            }
            node = node.next;
            c++;
        }
        return node;
    }

    private void ensureIndex(int index) {
        if (index > size) {
            throw new RuntimeException("Index: " + index + ", size: " + size);
        }
    }

    public T get(int index) {
        ensureIndex(index);
        return (T) getNode(index).element;
    }


    private class Node {
        Object element;
        Node prev;
        Node next;

        public Node(Object element) {
            this.element = element;
            this.prev = this.next = null;
        }

        public Node(Object element, Node prev, Node next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
