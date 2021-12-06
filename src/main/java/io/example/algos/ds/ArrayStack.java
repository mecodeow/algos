package io.example.algos.ds;

public class ArrayStack<T> {
    private Object[] elements;
    private int initialSize = 10;
    private int top = -1;

    public ArrayStack(int initialSize) {
        this.initialSize = initialSize;
        elements = new Object[initialSize];
    }

    public ArrayStack() {
        elements = new Object[initialSize];
    }

    public int size() {
        return top + 1;
    }

    public void push(T e) {
        if (top >= elements.length) {
            throw new RuntimeException("Stack Overflow");
        }
        elements[++top] = e;
    }

    public T pop() {
        if (size() == 0) {
            throw new RuntimeException("Stack Underflow");
        }
        T element = (T) elements[top];
        elements[top--] = null;
        return element;
    }

    public T peek() {
        if (size() == 0) {
            throw new RuntimeException("Stack Underflow");
        }
        return (T) elements[top];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        elements = new Object[initialSize];
        top = -1;
    }
}
