package io.example.algos.sort;

public class QuickSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partitionA(arr, start, end);
            sort(arr, start, pivot - 1);
            sort(arr, pivot + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = start;
        boolean isSwap = false;
        for (int i = start; i < end; i++) {
            if (arr[i] > arr[end]) {
                if (!isSwap) {
                    isSwap = true;
                    pivot = i;
                }
            } else {
                if (isSwap) {
                    swap(arr, i, pivot);
                    pivot++;
                    isSwap = true;
                }
            }
        }
        if (!isSwap) {
            return end;
        } else {
            swap(arr, pivot, end);
        }

        return pivot;
    }

    private int partitionA(int[] arr, int start, int end) {
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (arr[j] < arr[end]) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, ++i, end);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int value = arr[i];
        arr[i] = arr[j];
        arr[j] = value;
    }

}
