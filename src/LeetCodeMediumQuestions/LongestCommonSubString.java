package LeetCodeMediumQuestions;

/**
 * @author sravan created on Sep 4, 2017
 *
 */

/*
 * The longest common substring problem is to find the longest string that is a
 * substring of two or more strings. This is different from Longest Common
 * Subsequence problem in the sense that substring should be continuous string
 * rather than just the occurance of common characters
 * 
 */

// Inspired from
// https://www.programcreek.com/2015/04/longest-common-substring-java/

public class LongestCommonSubString {

	public int getLongestCommonSubString(String a, String b) {
		// Approach - Similar to LCS problem except that memo size will be m*n
		// as there is no need to maintain an extra layer of zeros along the row
		// and column. memo[i][j] - represents the length of longest substring
		// formed till a[i] and b[j] both including. In LCS there is no need
		// that a[i] or b[j] should be included in the result whereas in this
		// case, it is essential
		int aLen = a.length();
		int bLen = b.length();
		
		int[][] memo = new int[aLen][bLen];
		int maxLen = 0;
		
		for(int i=0; i < aLen; i++) {
			for(int j=0; j < bLen; j++) {
				if(a.charAt(i) == b.charAt(j)) {
					if(i == 0 || j == 0)
						memo[i][j] = 1;
					else
						memo[i][j] = memo[i-1][j-1] + 1;
					// Maintain maxLen for each iteration
					maxLen = Math.max(maxLen, memo[i][j]);
				}
			}
		}
		return maxLen;
	}

}
