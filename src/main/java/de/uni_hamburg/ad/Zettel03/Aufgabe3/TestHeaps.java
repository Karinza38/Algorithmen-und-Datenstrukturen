package de.uni_hamburg.ad.Zettel03.Aufgabe3;

import java.util.Arrays;
import java.util.Comparator;


public class TestHeaps {
    public static void main(String[] args) {
        init2();
    }

    private static void init() {
        Heap a1 = new Heap(7, 12, 21, 42, 3, 1, 17, 8, 16, 20, 4);
        Heap a2 = new Heap(100, 99, 98, 2, 97, 9, 10);
        merge(a2.getArray(), a1.getArray());
        merge(a1.getArray(), a2.getArray());
    }

    private static void init2() {
        Heap a1 = new Heap(7, 12, 21, 42, 3, 1, 17, 8, 16, 20, 4);
        Heap a2 = new Heap(100, 99, 98);
        int[] a = new int[a1.size() + a2.size()];
        int k = 0;
        for (int i : a1.getArray()) {
            a[k++] = i;
        }
        for (int i : a2.getArray()) {
            a[k++] = i;
        }
        new Heap(false, a).beautifulPrint();
        a = Arrays.stream(a).boxed().sorted(Comparator.reverseOrder())
                        .mapToInt(i -> i).toArray(); // counting-sort
        new Heap(false, a).beautifulPrint();
    }

    private static void merge(int[] a1, int[] a2) {
        int[] a = new int[a1.length + a2.length];
        int j = 0, k = 0;
        while (j + k < a.length) {
            if (k == a2.length || j != a1.length && a1[j] > a2[k])
                a[j + k] = a1[j++];
            else
                a[j + k] = a2[k++];
        }
        new Heap(false, a).beautifulPrint();
    }


}
