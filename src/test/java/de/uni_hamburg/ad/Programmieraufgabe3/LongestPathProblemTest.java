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

  @Test
  void calc2() {
    // Arrange
    int[][] arr = new int[][]{{3, 4}, {1, 5}, {1, 4}, {4, 5}, {2, 5}};
    int N = 5;

    // Act
    final int result = lpp.calc(N, arr);

    // Arrange
    assertThat(result, is(2));
  }

  @Test
  void calc3() {
    // Arrange
    int[][] arr = new int[][]{{1, 2}, {3, 4}, {1, 5}, {3, 7}, {4, 6}, {5, 7}, {2, 3}, {6, 7}, {2, 6}, {5, 6}, {1, 6}, {2, 5}, {4, 7}};
    int N = 7;

    // Act
    final int result = lpp.calc(N, arr);

    // Arrange
    assertThat(result, is(5));
  }

  @Test
  void calc4() {
    // Arrange
    int[][] arr = new int[][]{{2, 4}, {4, 6}, {2, 3}, {5, 6}, {3, 6}, {1, 6}, {1, 3}, {3, 5}};
    int N = 6;

    // Act
    final int result = lpp.calc(N, arr);

    // Arrange
    assertThat(result, is(3));
  }
}
