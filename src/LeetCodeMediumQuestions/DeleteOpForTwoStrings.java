package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 23, 2018
 */

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * make word1 and word2 the same, where in each step you can delete one
 * character in either string.
 * 
 * Example 1: Input: "sea", "eat" Output: 2 Explanation: You need one step to
 * make "sea" to "ea" and another step to make "eat" to "ea". Note: The length
 * of given words won't exceed 500. Characters in given words can only be
 * lower-case letters.
 * 
 */

public class DeleteOpForTwoStrings {
	// Approach: Direct DP. Can also be done as finding the LCS value and returning
	// m+n-2*lcs. This approach is more straightforward
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int[][] memo = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			memo[i][0] = i;
		for (int j = 0; j <= n; j++)
			memo[0][j] = j;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					memo[i][j] = memo[i - 1][j - 1];
				else {
					memo[i][j] = 1 + Math.min(memo[i - 1][j], memo[i][j - 1]);
				}
			}
		}
		return memo[m][n];
	}
}
