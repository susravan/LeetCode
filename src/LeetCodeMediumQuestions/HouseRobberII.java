package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 28, 2018
 */

/**
 * Note: This is an extension of House Robber.
 * 
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thievery so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 */

// Inspired from https://leetcode.com/problems/house-robber-ii/discuss/59934
public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		// Either remove the first house or the last house and take the max of those two
		return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
	}

	private int rob(int[] nums, int lo, int high) {
		int rob = 0, notRob = 0;

		for (int i = lo; i < high; i++) {
			int temp = rob;
			rob = notRob + nums[i];
			notRob = Math.max(temp, notRob);
		}
		return Math.max(rob, notRob);
	}
}
