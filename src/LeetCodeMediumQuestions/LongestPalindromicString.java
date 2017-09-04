package LeetCodeMediumQuestions;

/**
 * @author sravan created on Sep 4, 2017
 *
 */

/*
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer. Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 *
 */

// Inspired from
// https://leetcode.com/problems/longest-palindromic-substring/solution/#approach-2-brute-force-time-limit-exceeded

public class LongestPalindromicString {

	public String getLongestPalindromicString(String str) {
		if (str.length() < 2)
			return str;

		// Approach: Given a string with length n, it will have 2*n - 1 centers
		// around which the string can be divided (Including dividing in-between
		// two characters). traverse the string from center towards both the
		// ends and check if it is a palindrome.
		int start = 0, end = 0;
		for (int i = 0; i < str.length(); i++) {
			// Center is ith character
			int len1 = expandAroundCenter(str, i, i);
			// Center is in between ith and (i+1)th character
			int len2 = expandAroundCenter(str, i, i + 1);
			int len = Math.max(len1, len2);

			// start and end contains the indicies of max_so_far palindrome
			// string
			if (len > end - start) {
				// Remember these equations to reconstruct start and end from
				// known center and length of the string
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return str.substring(start, end + 1);

	}

	private int expandAroundCenter(String str, int L, int R) {
		// Traverse the string from center moving towards edges from both the
		// ends
		while (L >= 0 && R < str.length() && str.charAt(L) == str.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}

}
