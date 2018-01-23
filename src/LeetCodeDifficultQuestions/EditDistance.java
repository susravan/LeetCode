package LeetCodeDifficultQuestions;

/**
 * @author Sravan
 * Created on Jan 23, 2018
 */

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 */

// Inspired from https://leetcode.com/problems/edit-distance/discuss/
public class EditDistance {
	// Approach: DP with O(N^2) space, O(M*N) time
	// Can be done in O(min(M, N)) space, will update the solution in future
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int[][] memo = new int[m + 1][n + 1];

		// Fill up first row and column
		for (int i = 0; i <= m; i++)
			memo[i][0] = i;
		for (int i = 0; i <= n; i++)
			memo[0][i] = i;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					memo[i][j] = memo[i - 1][j - 1];
				else {
					// When operations takes place on word2
					int insertSteps = memo[i][j - 1] + 1;
					int deleteSteps = memo[i - 1][j] + 1;
					int replaceSteps = memo[i - 1][j - 1] + 1;
					memo[i][j] = Math.min(Math.min(insertSteps, deleteSteps), replaceSteps);
				}
			}
		}
		return memo[m][n];
	}
}
