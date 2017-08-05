package LeetCodeMediumQuestions;

/**
 * @author sravan
 * created on Aug 4, 2017
 *
 */

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */

/* Inspired from https://leetcode.com/problems/maximum-subarray/discuss/
 */

public class MaximumSubArray {

	public int maximumSubArray(int[] nums) {
		// Using Dynamic Programming
		int max_so_far = nums[0];
		int max_curr = nums[0];
		
		for(int i=1; i < nums.length; i++) {
			max_curr = Math.max(nums[i], max_curr + nums[i]);
			max_so_far = Math.max(max_curr, max_so_far);
		}
		return max_so_far;
	}

}
