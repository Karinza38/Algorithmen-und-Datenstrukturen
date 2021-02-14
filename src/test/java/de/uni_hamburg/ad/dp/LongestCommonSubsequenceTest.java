package de.uni_hamburg.ad.dp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class LongestCommonSubsequenceTest
{

	LongestCommonSubsequence lcs = new LongestCommonSubsequence();

	@Test
	void solve_givenEmptySource_thatResultIsAlsoEmpty() {
		// Arrange
		var source = "";
		var target = "abc";

		// Act
		final String solution = lcs.solve(source, target);

		// Assert
		assertThat(solution, is(""));
	}

	@Test
	void solve_givenEmptyTarget_thatResultIsAlsoEmpty() {
		// Arrange
		var source = "abc";
		var target = "";

		// Act
		final String solution = lcs.solve(source, target);

		// Assert
		assertThat(solution, is(""));
	}

	@Test
	void solve_givenConsecutiveMatchingString_thatResultIsAbc() {
		// Arrange
		var source = "abcdef";
		var target = "abc";

		// Act
		final String solution = lcs.solve(source, target);

		// Assert
		assertThat(solution, is("abc"));
	}

	@Test
	void solve_givenOnlyPatchedMatching_thatResultIsAcf() {
		// Arrange
		var source = "abc";
		var target = "";

		// Act
		final String solution = lcs.solve(source, target);

		// Assert
		assertThat(solution, is(""));
	}

	@Test
	void solve_givenMixedAndSortedNumbers_thatResultIs12356() {
		// Arrange
		var source = "132535365";
		var target = "123456789";

		// Act
		final String solution = lcs.solve(source, target);

		// Assert
		assertThat(solution, is("12356"));
	}

	@Test
	@Disabled // 5m 23s 813ms
	void solve_givenBigTestCase_thatResultIsCorrect() {
		// Arrange
		var source = "lRk3W1I9WxwL8u3l2GA4";
		var target = "3In9qxKcLuN963Yxlvq4";

		// Act
		final String solution = lcs.solve(source, target);

		// Assert
		assertThat(solution, is("3I9xLu3l4"));
	}

	/**
	 * DP
	 */
	@Test
	void solveDP_givenEmptySource_thatResultIsAlsoEmpty() {
		// Arrange
		var source = "";
		var target = "abc";

		// Act
		final String solution = lcs.solveDP(source, target);

		// Assert
		assertThat(solution, is(""));
	}

	@Test
	void solveDP_givenEmptyTarget_thatResultIsAlsoEmpty() {
		// Arrange
		var source = "abc";
		var target = "";

		// Act
		final String solution = lcs.solveDP(source, target);

		// Assert
		assertThat(solution, is(""));
	}

	@Test
	void solveDP_givenConsecutiveMatchingString_thatResultIsAbc() {
		// Arrange
		var source = "abcdef";
		var target = "abc";

		// Act
		final String solution = lcs.solveDP(source, target);

		// Assert
		assertThat(solution, is("abc"));
	}

	@Test
	void solveDP_givenOnlyPatchedMatching_thatResultIsAcf() {
		// Arrange
		var source = "abc";
		var target = "";

		// Act
		final String solution = lcs.solveDP(source, target);

		// Assert
		assertThat(solution, is(""));
	}

	@Test
	void solveDP_givenMixedAndSortedNumbers_thatResultIs12356() {
		// Arrange
		var source = "132535365";
		var target = "123456789";

		// Act
		final String solution = lcs.solveDP(source, target);

		// Assert
		assertThat(solution, is("12356"));
	}

	@Test
	@Disabled // 5m 8s 232ms
	void solveDP_givenBigTestCase_thatResultIsCorrect() {
		// Arrange
		var source = "lRk3W1I9WxwL8u3l2GA4";
		var target = "3In9qxKcLuN963Yxlvq4";

		// Act
		final String solution = lcs.solveDP(source, target);

		// Assert
		assertThat(solution, is("3I9xLu3l4"));
	}
}