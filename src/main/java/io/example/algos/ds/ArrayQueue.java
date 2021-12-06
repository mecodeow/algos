package io.example.algos.ds;

public class ArrayQueue<T> {
    private Object[] elements;
    private int initialSize = 10;
    private int head = -1;
    private int tail = -1;

    public ArrayQueue(int initialSize) {
        this.initialSize = initialSize;
        elements = new Object[initialSize];
    }

    public ArrayQueue() {
        elements = new Object[initialSize];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        elements = new Object[initialSize];
        head = tail = -1;
    }

    public int size() {
        return tail + 1;
    }

    public void enqueue(T e) {
        if (size() >= elements.length) {
            throw new RuntimeException("Queue is full");
        }
        if (size() == 0) {
            elements[++head] = e;
            tail = head;
        } else {
            elements[++tail] = e;
        }
    }

    public T dequeue() {
        if (size() == 0) {
            throw new RuntimeException("Queue is empty");
        }
        T e = (T) elements[head];
        shiftAllToLeft();
        return e;
    }

    public T peek() {
        if (size() == 0) {
            throw new RuntimeException("Queue is empty");
        }
        return (T) elements[head];
    }

    private void shiftAllToLeft() {
        for (int i = 1; i <= tail; i++) {
            elements[i - 1] = elements[i];
        }
        elements[tail--] = null;
        if (tail == -1) {
            head = -1;
        }
    }
}
