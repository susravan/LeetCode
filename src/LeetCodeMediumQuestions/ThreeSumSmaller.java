package LeetCodeMediumQuestions;

import java.util.Arrays;

/**
 * @author Sravan
 * Created on Mar 16, 2018
 */

/**
 * Given an array of n integers nums and a target, find the number of index
 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] +
 * nums[j] + nums[k] < target.
 * 
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * 
 * Return 2. Because there are two triplets which sums are less than 2:
 * 
 * [-2, 0, 1] [-2, 0, 3] Follow up: Could you solve it in O(n2) runtime?
 * 
 * 
 */

// Inspired from
public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		int smallerSum = 0, diff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		int count = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			int lo = i + 1, high = nums.length - 1;

			while (lo < high) {
				int sum = nums[i] + nums[lo] + nums[high];
				if (sum >= target) {
					high--;
				} else {
					count += high - lo;
					lo++;
				}
			}
		}
		return count;
	}
}
