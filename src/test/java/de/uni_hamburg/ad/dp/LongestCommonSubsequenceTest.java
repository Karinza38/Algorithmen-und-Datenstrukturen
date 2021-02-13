package de.uni_hamburg.ad.dp;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
}