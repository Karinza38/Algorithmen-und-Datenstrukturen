package de.uni_hamburg.ad.Zettel03.Aufgabe2;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {

    public static void main(String[] args) {
        sort(new int[]{20, 13, 8, 5, 2, 12, 9});
    }

    public static void sort(int[] arr) {
        System.out.println("Input: " + formatToPrettyString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("Output: " + formatToPrettyString(arr));
        checkIsSorted(arr);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            System.out.println("Pivot element index: " + p + " value: " + arr[p]);
            System.out.println("Intermediate: " + formatToPrettyString(arr) + "\n");
            sort(arr, l, p - 1);
            sort(arr, p + 1, r);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int x = arr[r];
        int i = l - 1;
        for (int j = l; j < r; ++j) {
            if (arr[j] <= x) {
                ++i;
                swap(arr, i, j);
            }
        }
        swap(arr, ++i, r);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static String formatToPrettyString(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    private static void checkIsSorted(int[] arr) {
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        for (int i = 0; i < arr.length; ++i) {
            assert arr[i] == sorted[i] : "sorted at position " + i + " " + arr[i] + " should be " + sorted[i];
        }
    }
}
