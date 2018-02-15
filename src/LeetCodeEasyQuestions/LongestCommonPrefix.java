package LeetCodeEasyQuestions;

// This same question can be done in multiple other ways. Although this is the most effcient way, its good to know all other approaches
// Refer - https://leetcode.com/problems/longest-common-prefix/solution/ Especially binary search and trie approaches are good
/**
 * @author Sravan
 * Created on Feb 14, 2018
 */

/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * 
 */

// Inspired from
public class LongestCommonPrefix {
	public String getLongestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];

		StringBuilder sb = new StringBuilder(strs[0]);

		for (int i = 1; i < strs.length; i++) {
			String str = strs[i];
			int j = 0;
			System.out.println(sb.length());
			while (j < str.length() && j < sb.length()) {
				if (str.charAt(j) != sb.charAt(j)) {
					sb = sb.delete(j, str.length());
					break;
				}
				j++;
			}
		}
		return sb.toString();
	}
}
