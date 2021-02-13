package de.uni_hamburg.ad.Knapsack;

import lombok.extern.slf4j.Slf4j;

import java.security.InvalidAlgorithmParameterException;

@Slf4j
public class Knapsack01
{
	public static double solve(double[] values, int[] weights, int capacity) {
		if (values.length != weights.length)
				throw new IllegalArgumentException("Both arrays should be of equal length");

		final int[][] dp = new int[weights.length+1][capacity+1];
		int i,j = 0;
		for (i = 1; i <= weights.length; ++i) {
			for (j = 0; j <= capacity; ++j) {
				if (weights[i-1] > j)
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][Math.max(0,j-weights[i-1])] + (int)(values[i-1]*10));
			}
		}
		for (int[] ints : dp) log.info("{}", ints);
		return dp[i-1][j-1]/10d;
	}
}
