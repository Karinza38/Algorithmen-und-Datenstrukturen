package de.uni_hamburg.ad.Zettel03.Aufgabe3;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Heap {
    private final int[] a;
    /**
     * Zeigt auf den nächsten freien Platz im Array a
     */
    private int n;

    public Heap(int max) {
        this.a = new int[max];
        this.n = 0;
    }

    public Heap(int... arr) {
        this.n = 0;
        this.a = new int[arr.length];
        for (int i : arr) {
            insert(i);
        }
    }

    public Heap(boolean heapify, int... arr) {
        this.n = arr.length;
        this.a = arr;
    }

    public void insert(int e) {
        a[n] = e;
        heapifyUp(n);
        n++;
    }

    public int max() {
        assert n >= 0;

        return a[0];
    }

    public int deleteMax() {
        assert n > 0;

        final int tmp = a[0];
        a[0] = a[--n];
        heapifyDown();
        return tmp;
    }

    public boolean isMaxHeap() {
        for(int i = 0; i < n; ++i) {
            if (left(i)<n && a[left(i)] > a[i] || right(i) < n && a[right(i)] > a[i])
                return false;
        }
        return true;
    }

    public int size() {
        return n;
    }

    public int[] getArray() {
        return Arrays.copyOf(a, a.length);
    }

    private void heapifyDown() {
        int i = 0;
        while (left(i) < n) {
            int m;
            if (right(i) > n) {
                m = left(i);
            } else {
                if (key(a[left(i)]) > key(a[right(i)]))
                    m = left(i);
                else
                    m = right(i);
            }
            if (key(a[i]) >= key(a[m])) {
                return;
            }
            swap(i, m);
            i = m;
        }
    }

    private int key(int e) {
        for(int i = 0; i <= n; ++i) {
            if (a[i] == e)
                return i;
        }

        assert false : "FUCK";
        return -1;
    }

    private int left(int i) {
        return i * 2;
    }

    private int right(int i) {
        return i * 2 + 1;
    }

    private void heapifyUp(int i) {
        while (i > 0 && a[parent(i)] < a[i]) {
            final int parent = parent(i);
            swap(i, parent);
            i = parent;
        }
    }

    private void swap(int i, int parent) {
        int tmp = a[i];
        a[i] = a[parent];
        a[parent] = tmp;
    }

    private int parent(int e) {
        assert e != 0;

        return e / 2;
    }

    @Override
    public String toString() {
        return Arrays.stream(a).mapToObj(String::valueOf).collect(
                        Collectors.joining(", ","Heap "+(isMaxHeap()?"Yes":"No")+"[","]"));
    }

    public void beautifulPrint() {
        System.out.println(toString());
    }
}
