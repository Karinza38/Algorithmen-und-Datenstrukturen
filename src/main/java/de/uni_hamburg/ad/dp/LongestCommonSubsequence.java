package de.uni_hamburg.ad.dp;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class LongestCommonSubsequence
{
	private static boolean debug = false;

	private LongestCommonSubsequence() {
	}

	public static String solve(String x, String y) {
		LcsMatrix matrix = new LcsMatrix(x, y);
		return matrix.traceback();
	}

	static void setDebug(boolean debug) {
		LongestCommonSubsequence.debug = debug;
	}

	private static class LcsMatrix {
		private final String stringX;
		private final String stringY;

		private final int[][] lcsLengths;

		//Store the lengths of the lcs and trace back to find the lcs
		LcsMatrix(String x, String y) {
			stringX = x;
			stringY = y;

			//Make dimensions one bigger to include the empty string column and row
			lcsLengths = new int[x.length()+1][y.length()+1];
			//Take advantage of 0 default for row and column 0

			for(int i = 1; i <= x.length(); i++) {
				for(int j = 1; j <= y.length(); j++) {
					if(x.charAt(i-1) == y.charAt(j-1)) {
						lcsLengths[i][j] = 1 + lcsLengths[i-1][j-1];
					} else {
						lcsLengths[i][j] = Math.max(lcsLengths[i-1][j], lcsLengths[i][j-1]);
					}
				}
			}
			if (debug) Arrays.asList(lcsLengths).forEach(row -> log.info("{}",row));
		}

		String traceback() {
			int x = stringX.length();
			int y = stringY.length();

			StringBuilder result = new StringBuilder();

			//Once we hit the empty string row or column, we should have the subsequence
			while(x != 0 && y != 0) {
				if(stringX.charAt(x - 1) == stringY.charAt(y - 1)) {
					result.append(stringX.charAt(x - 1));
					x--;
					y--;
				} else if(lcsLengths[x-1][y] > lcsLengths[x][y-1]) {
					x--;
				} else {
					y--;
				}
			}
			return result.reverse().toString();
		}
	}
}
