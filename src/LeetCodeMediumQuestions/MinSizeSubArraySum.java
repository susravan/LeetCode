package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Apr 20, 2018
 */

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 */

// Inspired from
public class MinSizeSubArraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int lo = 0, high = 0;
		int minLen = Integer.MAX_VALUE, sum = 0;

		while (high < nums.length) {
			sum += nums[high];

			while (sum >= s) {
				minLen = Math.min(minLen, high - lo + 1);
				sum -= nums[lo];
				lo++;
			}
			high++;
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
}
