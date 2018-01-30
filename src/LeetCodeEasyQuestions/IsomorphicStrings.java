package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Jan 30, 2018
 */

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * 
 */

// Inspired from https://leetcode.com/problems/isomorphic-strings/discuss/57963
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] charSMap = new int[128];
		int[] charTMap = new int[128];

		// Instead of using hashmap, we are using 2 arrays containing the latest
		// position where it is seen. When 2 characters are seen at same position, they
		// need to have same last seen position also, otherwise not isomorphic
		for (int i = 0; i < s.length(); i++) {
			if (charSMap[s.charAt(i)] != charTMap[t.charAt(i)]) {
				return false;
			}
			charSMap[s.charAt(i)] = i + 1; // start from 1 instead of 0 (as 0 is default value)
			charTMap[t.charAt(i)] = i + 1;
		}
		return true;
	}
}
