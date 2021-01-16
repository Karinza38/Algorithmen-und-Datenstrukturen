package de.uni_hamburg.ad;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Recursion {

    String[] tailRecursion(int n, String[] accumulator, Random rnd) {
        if (n == 0) {
            return accumulator;
        }
        accumulator[n - 1] = rnd.nextBoolean() ? "red" : "blue";
        return tailRecursion(n - 1, accumulator, rnd);
    }

    long fib(int n) {
        if (n == 0 || n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    BigInteger fibFast(int n, Map<Integer, BigInteger> dyn) {
        if (n == 0 || n == 1)
            return BigInteger.ONE;
        if (!dyn.containsKey(n))
            dyn.put(n, fibFast(n - 1, dyn).add(fibFast(n - 2, dyn)));
        return dyn.get(n);
    }

    BigInteger fibFastIter(int n) {
        Map<Integer, BigInteger> dyn = new HashMap<>();
        dyn.put(0, BigInteger.ONE);
        dyn.put(1, BigInteger.ONE);
        int i = 1;
        while (n > i) {
            dyn.put(++i, dyn.get(i - 1).add(dyn.get(i - 2)));
        }
        return dyn.get(n);
    }

    BigInteger fibFastestIter(int n) {
        var a = new BigInteger[] { BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO };
        int i = 1;
        while (n >= i) {
            var n1 = a[(i + 2) % 3];
            var n2 = a[(i + 1) % 3];
            a[(i++) % 3] = n1.add(n2);
        }
        return a[n % 3];
    }

}
