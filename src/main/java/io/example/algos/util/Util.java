package io.example.algos.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Util {
    public static void print(int[] arr) {
        String s = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println(s);
    }

    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int value = arr[i];
            arr[i] = arr[j];
            arr[j] = value;
        }
    }
}
