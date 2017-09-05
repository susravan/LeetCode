package LeetCodeMediumQuestions;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author sravan
 * created on Aug 23, 2017
 *
 */

/*  Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */

// Inspired from https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/

public class LongestSubStringWithoutRepeatingCharacters {

	public int getLongestSubStringWithoutRepeatingCharacters(String s) {
		if(s.length() < 2)
			return s.length();
		
		int left = 0, right = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		
		while(right < s.length()) {
			char currChar = s.charAt(right);
			if(!map.containsKey(currChar))
				map.put(currChar, right);
			else {
				left = map.get(currChar);
				maxLen = Math.max(maxLen, right - left);
				System.out.println("Right = " + right + " left = " + left);
				
				
			}
			right++;
		}
		return maxLen;
	}

}
