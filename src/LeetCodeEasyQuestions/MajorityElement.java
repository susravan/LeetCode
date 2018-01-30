package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Jan 29, 2018
 */

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 */

// Inspired from https://leetcode.com/problems/majority-element/solution/
public class MajorityElement {
	// Approach: Boyre-Moore voting algorithm
	public int majorityElement(int[] nums) {
		int maj = 0, count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (count == 0)
				maj = nums[i];
			count += (nums[i] == maj) ? 1 : -1;
		}
		return maj;
	}
}
