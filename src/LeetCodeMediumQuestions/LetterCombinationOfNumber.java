package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

		HashMap<Character, char[]> map = new HashMap<>();
		map.put('2', new char[] { 'a', 'b', 'c' });
		map.put('3', new char[] { 'd', 'e', 'f' });
		map.put('4', new char[] { 'g', 'h', 'i' });
		map.put('5', new char[] { 'j', 'k', 'l' });
		map.put('6', new char[] { 'm', 'n', 'o' });
		map.put('7', new char[] { 'p', 'q', 'r', 's' });
		map.put('8', new char[] { 't', 'u', 'v' });
		map.put('9', new char[] { 'w', 'x', 'y', 'z' });

		List<String> res = new ArrayList<>();
		List<Character> charList = new ArrayList<>();
		for (int i = 0; i < numStr.length(); i++) {
			charList.add(numStr.charAt(i));
		}

		for (int i = 0; i < charList.size(); i++) {
			char currChar = charList.get(i);

			if (res.size() == 0) {
				char[] toAppend = map.get(currChar);
				for (int k = 0; k < toAppend.length; k++) {
					res.add(toAppend[k] + "");
				}
			} else {
				List<String> updatedList = new ArrayList<>();
				for (int j = 0; j < res.size(); j++) {
					char[] toAppend = map.get(currChar);
					for (int k = 0; k < toAppend.length; k++) {
						updatedList.add(res.get(j) + toAppend[k]);
					}
				}
				res = updatedList;
			}
		}
		return res;
	}
}
