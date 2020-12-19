package de.uni_hamburg.ad.Zettel04;

public class WeihnachtsmannProblem {

    public static String calc(int[] a, int[] b) {
        final int[] resultat = new int[b.length];
        for (int i : a) {
            resultat[i]++;
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resultat.length; ++i) {
            sb.append(resultat[i] <= b[i] ? "1" : "0");
        }
        return sb.toString();
    }
}
