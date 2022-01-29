package de.uni_hamburg.ad.dp;

class Schilder {
    private Schilder() {
    }

    static long opt(long... w) {
        return optRec(w, 0);
        // return optJamin(w);
        // return optIterativ(w);
    }

    private static long optRec(long[] w, int i) {
        final var numbersLeft = w.length - i;
        return switch (numbersLeft) {
            case 0 -> 0;
            case 1 -> w[i];
            case 2 -> Math.max(w[i], w[i + 1]);
            default -> Math.max(w[i] + optRec(w, i + 2), w[i + 1] + optRec(w, i + 3));
        };
    }

    private static long optIter(final long[] w) {
        long a = 0;
        for (int i = 0; i < w.length; i++) {
            int rest = w.length - i;
            if (rest == 1) {
                a += w[i];
                i += 3;
            } else if (rest == 2) {
                a += Math.max(w[i], w[i + 1]);
                i += 2;
            } else if (rest == 3) {
                if (w[i] + w[i + 2] > w[i + 1]) {
                    a += w[i];
                } else {
                    a += w[i + 1];
                    i++;
                }
                i++;
            } else {
                final var p1 = w[i] + w[i + 2]; // a+c
                final var p2 = w[i + 1] + w[i + 3]; // b+d
                final var p3 = w[i] + w[i + 3]; // a+d
                if (p1 > p2 && p1 > p3 || p3 > p1) {
                    a += w[i];
                    i += 1;
                } else if (p1 > p2) {
                    a += w[i + 1];
                    i += 1;
                }
            }
        }
        return a;
    }

    static long optJamin(long[] W) {
        int a = 0;
        int l = W.length;

        if (l == 1) {
            return W[0];
        }
        if (l == 2) {
            return Math.max(W[0], W[1]);
        }

        for (int i = 1; i + 1 < l; i++) {
            if (W[i - 1] + W[i + 1] > W[i]) {
                if (W[i] == W[i + 1] && W[i - 1] < W[i]) {
                    a += W[i];
                    i += 2;
                } else {
                    a += W[i - 1];
                    i++;
                }
            } else {
                a += W[i];
                i += 2;
            }
        }

        if (W[l - 3] + W[l - 1] >= W[l - 2]) {
            if (W[l - 2] == W[l - 3] && W[l - 2] > W[l - 1]) {
                a += W[l - 2];
            } else {
                a += W[l - 1];
            }
        }
        return a;
    }

}
