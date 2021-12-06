package io.example.algos.ds;

public class ArrayQueueUsingStack<T> {

    private int initialSize = 10;

    private ArrayStack<T> enqueueStack;
    private ArrayStack<T> deQueueStack;


    public ArrayQueueUsingStack() {
        enqueueStack = new ArrayStack<>(initialSize);
        deQueueStack = new ArrayStack<>(initialSize);
    }

    public ArrayQueueUsingStack(int initialSize) {
        this.initialSize = initialSize;
        enqueueStack = new ArrayStack<>(initialSize);
        deQueueStack = new ArrayStack<>(initialSize);
    }

    public int size() {
        return enqueueStack.size() + deQueueStack.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        ensureStackShift();
        return deQueueStack.peek();
    }

    public void clear() {
        enqueueStack = new ArrayStack<>(initialSize);
        deQueueStack = new ArrayStack<>(initialSize);
    }

    public void enqueue(T e) {
        if (size() >= initialSize) {
            throw new RuntimeException("Queue is full");
        } else {
            enqueueStack.push(e);
        }
    }

    public T dequeue() {
        ensureStackShift();
        return deQueueStack.pop();
    }

    private void ensureStackShift() {
        if (deQueueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                deQueueStack.push(enqueueStack.pop());
            }
        }
        if (deQueueStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
    }
}
