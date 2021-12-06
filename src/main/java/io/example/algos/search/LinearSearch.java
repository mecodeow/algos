package io.example.algos.search;


/**
 * Problem: Given an array arr[] of n elements, write a function to search a given element x in arr[].
 * <p>
 * Examples :
 * <p>
 * Input : arr[] = {10, 20, 80, 30, 60, 50,
 * 110, 100, 130, 170}
 * x = 110;
 * Output : 6
 * Element x is present at index 6
 * <p>
 * Input : arr[] = {10, 20, 80, 30, 60, 50,
 * 110, 100, 130, 170}
 * x = 175;
 * Output : -1
 * Element x is not present in arr[].
 */

public class LinearSearch {
    public int search(int[] arr, int ele) {
        for (int index = 0; index < arr.length; index++) {
            if (ele == arr[index]) {
                return index;
            }
        }
        return -1;
    }

    public int searchModified(int[] arr, int ele) {
        int length = arr.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            if (ele == arr[left]) {
                return left;
            }
            if (ele == arr[right]) {
                return right;
            }
            left++;
            right--;
        }
        return -1;
    }
}
