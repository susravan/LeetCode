package LeetCodeDifficultQuestions;

/**
 * @author Sravan
 * Created on Jan 26, 2018
 */

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 */

// Inspired from
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		// Approach: Traverse string maintaining the charLen between string and pattern.
		// If charLen == pattern length, one window is found. Minimize this window by
		// moving the window's start pointer to right
		if (t.length() > s.length())
			return "";
		int sLen = s.length(), tLen = t.length();
		int[] hash_ptr = new int[128];
		int[] hash_str = new int[128];
		int minLen = Integer.MAX_VALUE, charLen = 0, start = 0, end = 0, startIndex = 0;

		for (int i = 0; i < tLen; i++)
			hash_ptr[t.charAt(i)]++;

		while (end < sLen) {
			int index = s.charAt(end);
			hash_str[index]++;
			// If the char is required, update length
			if (hash_ptr[index] != 0 && hash_str[index] <= hash_ptr[index])
				charLen++;
			// If len == t's size => we got all characters we want
			if (charLen == tLen) {
				// Reduce window size going from beginning
				while (start <= end) {
					index = s.charAt(start);
					if (hash_ptr[index] == 0 || hash_ptr[index] < hash_str[index]) {
						hash_str[index]--;
						start++;
					} else
						break;
				}
				if (minLen > end - start + 1) {
					minLen = end - start + 1;
					startIndex = start;
				}

				// Move start one pointer forward to get ready for next substring
				hash_str[index]--;
				if (hash_ptr[index] != 0)
					charLen--;
				start++;
			}
			end++;
		}
		if (minLen == Integer.MAX_VALUE)
			return "";
		return s.substring(startIndex, startIndex + minLen);
	}
}
