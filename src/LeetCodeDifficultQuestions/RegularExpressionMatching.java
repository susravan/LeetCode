package LeetCodeDifficultQuestions;

/**
 * @author Sravan
 * Created on Feb 5, 2018
 */

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa", ".*") →
 * true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") → true
 */

// Inspired from https://leetcode.com/problems/regular-expression-matching/solution/
public class RegularExpressionMatching {
	public boolean isMatch(String str, String ptr) {
		if (ptr.isEmpty())
			return str.isEmpty();

		boolean firstMatch = !str.isEmpty() && (ptr.charAt(0) == str.charAt(0) || ptr.charAt(0) == '.');

		if (ptr.length() >= 2 && ptr.charAt(1) == '*') {
			return isMatch(str, ptr.substring(2)) || (firstMatch && isMatch(str.substring(1), ptr));
		} else
			return firstMatch && isMatch(str.substring(1), ptr.substring(1));
	}
}
