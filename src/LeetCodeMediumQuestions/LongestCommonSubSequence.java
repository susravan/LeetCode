package LeetCodeMediumQuestions;

/**
 * @author sravan created on Sep 4, 2017
 *
 */

/*
 * The longest common subsequence (LCS) problem is the problem of finding the
 * longest subsequence common to all sequences in a set of sequences (often just
 * two sequences).
 *
 */


public class LongestCommonSubSequence {

	public int getLongestCommonSubSequence(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();

		// Kind of like robot grid problem
		int[][] memo = new int[aLen + 1][bLen + 1];

		for (int i = 0; i < aLen; i++) {
			for (int j = 0; j < bLen; j++) {
				// This extra layer of zeros allows us to use below expressions
				// peacefully
				// Otherwise many special cases needs to be considered
				if (i == 0 || j == 0)
					memo[i][j] = 0;
				else if (a.charAt(i) == b.charAt(j))
					memo[i][j] = memo[i - 1][j - 1] + 1;
				else
					memo[i][j] = Math.max(memo[i][j - 1], memo[i - 1][j]);
			}
		}
		return memo[aLen][bLen];
	}
}
