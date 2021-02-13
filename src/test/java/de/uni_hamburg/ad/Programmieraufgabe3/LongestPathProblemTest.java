package de.uni_hamburg.ad.Programmieraufgabe3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


class LongestPathProblemTest {
  
  LongestPathProblem lpp = new LongestPathProblem();
  
  @Test
  void calc1() {
    // Arrange
    int[][] arr = new int[][]{{1, 2}, {2, 3}};
    int N = 3;

    // Act
    final int result = lpp.calc(N, arr);

    // Arrange
    assertThat(result, is(2));
  }
}
