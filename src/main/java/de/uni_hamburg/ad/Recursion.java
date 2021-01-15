package de.uni_hamburg.ad;

import java.util.Random;

public class Recursion {

    String[] tailRecursion(int n, String[] accumulator, Random rnd)
    {
        if(n == 0) {
            return accumulator;
        }
        accumulator[n-1] = rnd.nextBoolean() ? "red" : "blue";
        return tailRecursion(n-1, accumulator, rnd);

    }
}
