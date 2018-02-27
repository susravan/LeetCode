package LeetCodeDifficultQuestions;

import java.util.Arrays;

/**
 * @author Sravan
 * Created on Feb 27, 2018
 */

/**
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 * 
 * For example, Given s = “eceba”,
 * 
 * T is "ece" which its length is 3.
 */

public class LongestSubstringAtmostTwoChars {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		// Similar to k distinct characters but used array instead of hashmap
		int[] charMap = new int[256];
		Arrays.fill(charMap, -1); // Important as storing index and it can be '0'
		int start = 0, end = 0;
		int uniqueChar = 0, maxLen = 0;

		while (end < s.length()) {
			char ch = s.charAt(end);

			// Only when new character is seen and already ahve sufficient unique characters
			if (charMap[ch] == -1 && uniqueChar == 2) {
				while (uniqueChar == 2) {
					char removeChar = s.charAt(start);

					// Remove a character from start and update charMap
					if (charMap[removeChar] == start) {
						uniqueChar--;
						charMap[removeChar] = -1;
					}
					start++;
				}
			}

			// Only when new character is seen
			if (charMap[ch] == -1)
				uniqueChar++;

			charMap[ch] = end;
			maxLen = Math.max(maxLen, end - start + 1);
			end++;
		}
		return maxLen;
	}
}
