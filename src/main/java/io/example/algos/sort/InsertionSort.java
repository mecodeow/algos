package io.example.algos.sort;

import io.xdev.util.Util;

/**
 * Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands.
 * The array is virtually split into a sorted and an unsorted part.
 * Values from the unsorted part are picked and placed at the correct position in the sorted part.
 */
public class InsertionSort {


    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int j = i;
            int value;
            while (j > 0 && arr[j - 1] > arr[j]) {
                Util.swap(arr, j - 1, j);
                Util.swap(arr, j - 1, j);
                j--;
            }
        }
    }
}
