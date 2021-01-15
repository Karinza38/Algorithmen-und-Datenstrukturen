package de.uni_hamburg.ad;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class RecursionTest {

    @Test void tailRecursion() {
        // Arrange
        Random rnd = new Random(123L);
        Recursion rec = new Recursion();

        // Act
        final String[] result = rec.tailRecursion(10, new String[10], rnd);

        // Assert
        assertThat(result, is(new String[] {"red", "red", "blue", "red", "red", "blue", "blue", "red", "blue", "red"}));
    }
}