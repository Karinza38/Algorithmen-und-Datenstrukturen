package de.uni_hamburg.ad.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SchilderTest {

    @Test void opt_hasOneElement_returnsOneElement() {
        assertEquals(5, Schilder.opt(5));
    }

    @Test void opt_hasTwoElements_returnsGreaterOne() {
        assertEquals(5, Schilder.opt(1, 5));
    }

    @Test void opt_hasThreeElements_returnsTheSumOfTheFirstAndLast() {
        assertEquals(5, Schilder.opt(2, 4, 3));
    }

    @Test void opt_hasThreeElements_returnsTheMiddleElement() {
        assertEquals(6, Schilder.opt(2, 6, 3));
    }

    @Test void opt_hasFiveElements_retunsTheSumOfTheFirstTheMiddleAndTheLast() {
        assertEquals(7, Schilder.opt(1, 2, 1, 4, 5));
    }

    @Test void opt_hasFiveElements2_retunsTheSumOfTheFirstTheMiddleAndTheLast() {
        assertEquals(18, Schilder.opt(10, 2, 3, 4, 5));
    }

    @Test void opt_doubleGapOne() {
        assertEquals(10, Schilder.opt(5,1,1,5));
    }

    @Test void opt_gapDoubleGap() {
        assertEquals(10, Schilder.opt(1,5,1,1,5));
    }

    @Test void opt_oneGapDoubleGap() {
        assertEquals(11, Schilder.opt(1,1,5,1,1,5));
    }

    @Test void opt_longRowOfSameValues() {
        assertEquals(10, Schilder.opt(1,5,5,5));
    }

    @Test void opt_longRowOfSameValues2() {
        assertEquals(10, Schilder.opt(5,5,5));
    }

    @Test void opt_longRowOfSameValues3() {
        assertEquals(10, Schilder.opt(5,5,5,1));
    }

    @Test void opt_tricky1131() {
        assertEquals(4, Schilder.opt(1,1,3,1));
    }

    @Test void opt_tricky1231() {
        assertEquals(4, Schilder.opt(1,2,3,1));
    }

    @Test void opt_tricky1331() {
        assertEquals(4, Schilder.opt(1,3,3,1));
    }

}