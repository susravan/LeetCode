package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Jan 28, 2018
 */

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 * 
 * 
 */

// Inspired from https://leetcode.com/problems/house-robber/discuss/55838/
public class HouseRobber {
	public int rob(int[] nums) {
		// Using constant space
		int rob = 0, notRob = 0;

		for (int i = 0; i < nums.length; i++) {
			int temp = rob; // rob refers to robbing i-1th house
			rob = nums[i] + notRob; // here notRob refers to value when i-1 is not robbed
			notRob = Math.max(temp, notRob); // here notRob should be max of robbing i-1 and i-2's values
		}
		return Math.max(rob, notRob);

		// Using linear space
		// if(nums.length == 0)
		// return 0;
		// if(nums.length < 3) {
		// return nums.length == 2 ? Math.max(nums[0], nums[1]) : nums[0];
		// }

		// int[] memo = new int[nums.length];
		// memo[0] = nums[0];
		// memo[1] = Math.max(nums[0], nums[1]);

		// for(int i=2; i < nums.length; i++) {
		// for(int j=i-2; j >= 0; j--) {
		// memo[i] = Math.max(memo[i], Math.max(memo[j], nums[i] + memo[j]));
		// }
		// }
		// // System.out.println(Arrays.toString(memo));
		// return Math.max(memo[nums.length-1], memo[nums.length-2]);
	}
}
