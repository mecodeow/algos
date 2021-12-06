package io.example.algos.sort;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
 */
public class BubbleSort {
    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int value = arr[i];
            for (int j = 0; j < len - i; j++) {
                if (arr[j] < value) {
                    arr[i] = arr[j];
                    arr[j] = value;
                } else {
                    value = arr[j];
                }
            }
        }
    }
}
