package LeetCodeMediumQuestions;

import java.util.HashMap;

/**
 * @author sravan created on Aug 23, 2017
 *
 */

/*
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */

// Inspired from
// https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/

public class LongestSubStringWithoutRepeatingCharacters {

	public int getLongestSubStringWithoutRepeatingCharacters(String s) {
		// left - start of substring, right - pointer to parse the string
		// Use a hashmap to put a character and it's index. If a character is already
		// seen, update left pointer to next to seen character, update its index in map.
		// Update maxLen at each step
		// There is no need to move back the left pointer at any point in time
		int left = 0, right = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int maxLen = 0;

		for (right = 0; right < s.length(); right++) {
			char currChar = s.charAt(right);
			if (map.containsKey(currChar)) {
				left = Math.max(map.get(currChar) + 1, left);
			}
			map.put(currChar, right);
			maxLen = Math.max(maxLen, right - left + 1);
			// System.out.println("left = " + left + " right = " + right + " size = " +
			// map.size());
		}
		return maxLen;
	}

}
