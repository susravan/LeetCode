package LeetCodeMediumQuestions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Sravan
 * Created on Jan 29, 2018
 */

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of
 * an integer.
 */

// Inspired from https://leetcode.com/problems/largest-number/solution/
public class LargestNumberFromAnArray {
	public String largestNumber(int[] nums) {
		String[] numString = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			numString[i] = String.valueOf(nums[i]);

		Arrays.sort(numString, new lexicCompare());
		StringBuilder sb = new StringBuilder();
		for (int i = numString.length - 1; i >= 0; i--)
			sb.append(numString[i]);

		// Avoid getting "00" in the result
		if (sb.charAt(0) == '0')
			return "0";

		return sb.toString();
	}

	private class lexicCompare implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			// Directly comparing a and b doesn't work. Take 30 and 3 for example
			return (a + b).compareTo(b + a);
		}
	}
}
