package de.uni_hamburg.ad.Knapsack;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Knapsack01Test
{

	@Test
	void solve_3items()
	{
		// Arrange
		var values = new double[] {1,2,3};
		var weights = new int[] {2,3,2};

		// Act
		final var maxValue = (int)Knapsack01.solve(values, weights, 5);

		// Assert
		assertThat(maxValue, is(5));
	}

	@Test
	void solve_lectureProblem()
	{
		// Arrange
		var values = new double[] {11,5,	2,	8,	14,9};
		var weights = new int[] {5,2,	1,	3,	7,	4};

		// Act
		final var maxValue = (int)Knapsack01.solve(values, weights, 6);

		// Assert
		assertThat(maxValue, is(15));
	}

	@Test
	void solve_lectureProblemRobinsModification()
	{
		// Arrange
		var values = new double[] {11,5,	2,	8,	14,9,1};
		var weights = new int[] {5,2,	1,	3,	7,	4,0};

		// Act
		final var maxValue = (int)Knapsack01.solve(values, weights, 6);

		// Assert
		assertThat(maxValue, is(16));
	}

	@Test
	void solve_lectureProblemRobinsModification2()
	{
		// Arrange
		var values = new double[] {1,11,5,	2,	8,	14,9};
		var weights = new int[] {0,5,2,	1,	3,	7,	4};

		// Act
		final var maxValue = (int)Knapsack01.solve(values, weights, 6);

		// Assert
		assertThat(maxValue, is(16));
	}

	@Test
	void solve_lol()
	{
		// Arrange
		var values = new double[] {0.1,1,1,1};
		var weights = new int[] {0,0,0,0};

		// Act
		final var maxValue = (int)Knapsack01.solve(values, weights, 0);

		// Assert
		assertThat(maxValue, is(3.1));
	}

}