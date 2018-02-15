package LeetCodeMediumQuestions;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sravan created on Sep 12, 2017
 *
 */

/*
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * 
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"]. Note: Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 *
 */

public class LetterCombinationOfNumber {
	public List<String> getLetterCombinationOfNumber(String numStr) {
		if (numStr.equals(""))
			return new LinkedList<>();

		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		LinkedList<String> list = new LinkedList<>();
		list.add(""); // Important for first iteration

		for (int i = 0; i < numStr.length(); i++) {
			// If the length of first string in queue equals the index that we are looking
			// for in numStr, we are looking at right string - Expand it by adding new
			// characters to it.
			while (list.peek().length() == i) {
				String currStr = list.remove();
				for (char ch : mapping[numStr.charAt(i) - '0'].toCharArray()) {
					list.add(currStr + ch);
				}
			}
		}
		return list;
	}
}
