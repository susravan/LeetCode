package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Mar 24, 2018
 */

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 * 
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * 
 * 
 */

// Inspired from
public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		int len = num.length();
		String allCombinations = "00 11 69 96 88";
		for (int i = 0; i < num.length(); i++) {
			if (!allCombinations.contains(num.charAt(i) + "" + num.charAt(len - 1 - i)))
				return false;
		}
		return true;
	}
}
