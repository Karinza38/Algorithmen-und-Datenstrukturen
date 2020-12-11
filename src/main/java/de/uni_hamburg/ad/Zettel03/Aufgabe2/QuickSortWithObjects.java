package de.uni_hamburg.ad.Zettel03.Aufgabe2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class QuickSortWithObjects {

    private static class Bag<T> implements Comparable<Bag<T>> {
        int index;
        final T item;

        private Bag(T item, int index) {
            this.item = item;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Bag[index: " + index + " item: " + item.toString()+"]";
        }

        @Override public int compareTo(Bag<T> o) {
            return this.index - o.index;
        }
    }

    public static void main(String[] args) {
        sort(new Bag[]{
                        new Bag<>("1",2),
                        new Bag<>("2", 2),
                        new Bag<>("",1)
        });
    }

    public static void sort(Bag[] arr) {
        System.out.println("Input: " + formatToPrettyString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("Output: " + formatToPrettyString(arr));
        checkIsSorted(arr);
    }

    private static void sort(Bag<String>[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            System.out.println("Pivot element index: " + p + " value: " + arr[p]);
            System.out.println("Intermediate: " + formatToPrettyString(arr) + "\n");
            sort(arr, l, p - 1);
            sort(arr, p + 1, r);
        }
    }

    private static int partition(Bag<String>[] arr, int l, int r) {
        Bag<String> x = arr[r];
        int i = l - 1;
        for (int j = l; j < r; ++j) {
            if (arr[j].index <= x.index) {
                ++i;
                swap(arr, i, j);
            }
        }
        swap(arr, ++i, r);
        return i;
    }

    private static void swap(Bag<String>[] arr, int i, int j) {
        Bag<String> tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static String formatToPrettyString(Bag<String>[] arr) {
        return Arrays.stream(arr)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    private static void checkIsSorted(Bag<String>[] arr) {
        Bag[] sorted = Arrays.stream(arr).sorted().toArray(Bag[]::new);
        for (int i = 0; i < arr.length; ++i) {
            assert arr[i].index == sorted[i].index : "sorted at position " + i + " " + arr[i] + " should be " + sorted[i];
        }
    }
}
