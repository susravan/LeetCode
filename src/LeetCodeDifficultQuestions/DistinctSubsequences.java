package LeetCodeDifficultQuestions;

import java.util.Arrays;

/**
 * @author Sravan
 * Created on Jan 26, 2018
 */

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * S which equals T.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 *
 * Solution Explanation:
 * Let’s consider the same example as above: S = [acdabefbc], T = [ab]
              *  * 
      S = [acdabefbc]
mem[1] = [0111222222]
mem[2] = [00000222_ ]
Imagine that we are filling the gap at _. That means i=1, so T[i] = b and j=7, so S[j] = b.
We’re looking for mem[i+1][j+1], which is the place for _. Currently we know that at this position
we have 2 as before, because mem[1][7] = 2, which is the position ABOVE and LEFT to _. Also we
know that sofar we had 2 subsequences before (namely AcdaBef and acdABef – highlighted with uppercase)
because mem[2][7] = 2, which is LEFT to _. So having this new b would increase the number of
subsequences (currently 2) with a number of 2, because it can be matched with the 2 as we saw before.
That’s why if T[i] == S[j] then mem[i+1][j+1] := mem[i][j] + mem[i+1][j]. So _ will be 4.
 * 
 */

// Inspired from https://leetcode.com/problems/distinct-subsequences/discuss/37327
// See the explanation and the first comment
public class DistinctSubsequences {
	// Approach: DP with 2-D matrix, can be reduced to 1-D array
	// if S(i) == T(j), add its diag one and previous one, else continue with previous value
	// Diagonal value gives you the subsequences existing before you saw this character,
	// previous gives you the subsequences including current character you saw till now
	// if S(i) != T(j), no contribution by current char => get previous value itself
	public int numDistinct(String s, String t) {
		int sLen = s.length(), tLen = t.length();
		int[][] memo = new int[tLen + 1][sLen + 1];
		for (int col = 0; col <= sLen; col++)
			memo[0][col] = 1;

		for (int row = 1; row <= tLen; row++) {
			for (int col = 1; col <= sLen; col++) {
				if (s.charAt(col - 1) == t.charAt(row - 1))
					memo[row][col] = memo[row][col - 1] + memo[row - 1][col - 1];
				else
					memo[row][col] = memo[row][col - 1];
			}
		}
		return memo[tLen][sLen];
	}
}
