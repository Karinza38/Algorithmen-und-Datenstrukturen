package de.uni_hamburg.ad.dp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class LongestCommonSubsequenceTest
{

	@BeforeAll
	public static void setup() {
		LongestCommonSubsequence.setDebug(false);
	}

	@ParameterizedTest
	@CsvSource({",abc,",
			"abc,,",
			"abcdef,abc,abc",
			"abcdef,acf,acf",
			"132535365,123456789,12356",
			"abcdefghijklmnopq,abcdefghijklmnopq,abcdefghijklmnopq",
			"nothardlythefinaltest,zzzfinallyzzz,final",
			"lRk3W1I9WxwL8u3l2GA4,3In9qxKcLuN963Yxlvq4,3I9xLu3l4"})
	void solve_givenEmptySource_thatResultIsAlsoEmpty(String source, String target, String expected) {
		// Arrange
		source = source == null ? "" : source;
		target = target == null ? "" : target;
		expected = expected == null ? "" : expected;

		// Act
		final String solution = LongestCommonSubsequence.solve(source, target);

		// Assert
		assertThat(solution, is(expected));
	}

}