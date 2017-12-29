package LeetCodeMediumQuestions;

/**
 * @author sravan created on Sep 4, 2017
 *
 */

/*
 * Given a string, your task is to count how many palindromic substrings in this
 * string.
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters.
 * 
 * Example 1: Input: "abc" Output: 3 Explanation: Three palindromic strings:
 * "a", "b", "c". Example 2: Input: "aaa" Output: 6 Explanation: Six palindromic
 * strings: "a", "a", "a", "aa", "aa", "aaa". Note: The input string length
 * won't exceed 1000.
 *
 */


public class GetAllPalindromicSubStrings {

	public int getAllPalindromicSubStrings(String str) {
		// Approach: Similar to LongestPalindromicSubstring problem
		// For each of the 2*n - 1 centers, expand the string around the center
		int palinCount = 0;
		
		for(int i=0; i < str.length(); i++) {
			palinCount += expandAroundCenter(str, i, i);
			palinCount += expandAroundCenter(str, i, i + 1);
		}
		return palinCount;
	}
	
	private int expandAroundCenter(String str, int L, int R) {
		int count = 0;
		while(L >= 0 && R < str.length() && str.charAt(L) == str.charAt(R)) {
			// Every time there is a same character in the string, we increment count
			count++;
			L--;
			R++;
		}
		return count;
	}
}
