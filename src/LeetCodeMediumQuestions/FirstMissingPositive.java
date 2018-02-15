package LeetCodeMediumQuestions;

import java.util.Arrays;

/**
 * @author Sravan Given an unsorted integer array, find the first missing
 *         positive integer.
 * 
 *         For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 *         Your algorithm should run in O(n) time and uses constant space.
 *
 * 
 */

// Inspired from
// https://leetcode.com/problems/first-missing-positive/discuss/17073
public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		// Approach: Restructure the array to get all positive numbers first and then
		// negative numbers, use first k positive numbers to make values at those
		// indicies negative. Finally the first positive number is out result
		if (nums.length == 0)
			return 1;

		int left = 0, right = nums.length - 1;

		while (left < right) {
			if (nums[left] <= 0) {
				swap(nums, left, right);
				right--;
			} else {
				left++;
			}
		}
		// Update positive numbers' index values
		for (int i = 0; i <= left; i++) {
			int index = Math.abs(nums[i]);
			if (index - 1 <= left) {
				nums[index - 1] = nums[index - 1] > 0 ? -nums[index - 1] : nums[index - 1];
			}
		}
		System.out.println(Arrays.toString(nums));
		System.out.println(left);

		// Depending on index instead of actual values in the array => there cannot be
		// duplicates that masks the direct correlation between indicies and its values
		for (int i = 0; i <= left; i++) {
			if (nums[i] > 0)
				return i + 1;
		}
		return left + 2; // left is max postitive index, so add +2 to get number - one for index, one for
							// next value
	}

	private void swap(int[] nums, int i1, int i2) {
		int temp = nums[i1];
		nums[i1] = nums[i2];
		nums[i2] = temp;
	}
}
