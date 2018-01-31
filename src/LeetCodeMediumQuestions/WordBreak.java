package LeetCodeMediumQuestions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sravan Given a non-empty string s and a dictionary wordDict
 *         containing a list of non-empty words, determine if s can be segmented
 *         into a space-separated sequence of one or more dictionary words. You
 *         may assume the dictionary does not contain duplicate words.
 * 
 *         For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 *         Return true because "leetcode" can be segmented as "leet code".
 * 
 *         UPDATE (2017/1/4): The wordDict parameter had been changed to a list
 *         of strings (instead of a set of strings). Please reload the code
 *         definition to get the latest changes.
 */

// Inspired from https://leetcode.com/problems/word-break/discuss/

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		// Approach: Use memo array to store the substring till current index is present
		// in the dictionary
		if (s.length() == 0)
			return false;

		// Make a dictionary set
		Set<String> dict = new HashSet<>(wordDict);
		boolean[] memo = new boolean[s.length() + 1];
		memo[0] = true;

		for (int end = 1; end <= s.length(); end++) {
			for (int start = 0; start < end; start++) {
				if (memo[start] && dict.contains(s.substring(start, end))) {
					memo[end] = true;
				}
			}
		}
		return memo[s.length()];
	}
}
