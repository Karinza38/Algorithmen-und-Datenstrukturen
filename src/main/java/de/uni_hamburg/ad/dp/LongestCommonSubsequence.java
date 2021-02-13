package de.uni_hamburg.ad.dp;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence
{
	public String solve(String source, String target) {
		StringBuilder result = new StringBuilder();
		solveRec(source, target).forEach(result::append);
		return result.toString();
	}

	private List<Character> solveRec(String source, String target) {
		// If one of the parts is empty, they can't have anything common left to compare
		if (source.length() * target.length() == 0) {
			return new ArrayList<>();
		}
		final int endSourceIndex = source.length() - 1;
		final int endTargetIndex = target.length() - 1;
		if (source.charAt(endSourceIndex) == target.charAt(endTargetIndex)) {
			ArrayList<Character> result = new ArrayList<>();
			result.add(source.charAt(endSourceIndex));
			List<Character> middle = solveRec(source.substring(0, endSourceIndex), target.substring(0, endTargetIndex));
			result.addAll(0, middle);
			return result;
		}
		List<Character> leftResult = solveRec(source.substring(0, endSourceIndex), target);
		List<Character> rightResult = solveRec(source, target.substring(0, endTargetIndex));

		return leftResult.size() > rightResult.size() ? leftResult : rightResult;
	}
}
