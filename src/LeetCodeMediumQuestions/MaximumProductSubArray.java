package LeetCodeMediumQuestions;

/**
 * @author sravan
 * created on Aug 4, 2017
 *
 */

/*  Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *  For example, given the array [2,3,-2,4],
 *  the contiguous subarray [2,3] has the largest product = 6
 *
 */

// Inspired from https://www.youtube.com/watch?v=hAwHBxITB6g

public class MaximumProductSubArray {

	public int maximumProduct(int[] nums) {
		int max = nums[0], min = nums[0], res = nums[0];
		
		for(int i=1; i < nums.length; i++) {
			if(nums[i] > 0) {
				max = Math.max(nums[i], max * nums[i]);
				min = Math.min(nums[i], min * nums[i]);
			}
			else {
				int temp = max;
				max = Math.max(nums[i], min * nums[i]);
				min = Math.min(nums[i], temp * nums[i]);
			}
			res = Math.max(res, max);
		}
		return res;
	}

}
