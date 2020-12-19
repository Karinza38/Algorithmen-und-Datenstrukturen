package de.uni_hamburg.ad.Zettel04;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class WeihnachtsmannProblemTest {

    @Test void calc_givenFirstExample_returns0() {
        // Arrange
        int[] a = new int[] { 0, 0 };
        int[] b = new int[] { 0 };

        // Act
        final String resultat = WeihnachtsmannProblem.calc(a, b);

        // Assert
        assertThat(resultat, is("0"));
    }

    @Test void calc_givenSecondExample_returns11011() {
        // Arrange
        int[] a = new int[] { 2, 2, 2, 3, 4 };
        int[] b = new int[] { 0, 1, 2, 1, 3 };

        // Act
        final String resultat = WeihnachtsmannProblem.calc(a, b);

        // Assert
        assertThat(resultat, is("11011"));
    }

    @Test void calc_givenSecondExample_returns11100() {
        // Arrange
        int[] a = new int[] { 3, 4 };
        int[] b = new int[] { 0, 0, 0, 0, 0 };

        // Act
        final String resultat = WeihnachtsmannProblem.calc(a, b);

        // Assert
        assertThat(resultat, is("11100"));
    }
}