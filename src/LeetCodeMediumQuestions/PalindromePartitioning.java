package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sravan
 * Created on Feb 22, 2018
 */

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 */

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		if (s.equals(""))
			return null;

		List<List<String>> res = new ArrayList<>();
		helper(s, 0, new ArrayList<>(), res);
		return res;
	}

	private void helper(String str, int start, List<String> currList, List<List<String>> res) {
		if (start == str.length() && currList.size() > 0) {
			res.add(new ArrayList<>(currList));
			return;
		}

		for (int i = start; i < str.length(); i++) {
			if (isPalindrome(str.substring(start, i + 1))) {
				currList.add(str.substring(start, i + 1));
				helper(str, i + 1, currList, res);
				currList.remove(currList.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str) {
		int lo = 0, high = str.length() - 1;
		while (lo <= high) {
			if (str.charAt(lo) != str.charAt(high))
				return false;
			lo++;
			high--;
		}
		return true;
	}
}
