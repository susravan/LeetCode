package LeetCodeEasyQuestions;

import java.util.HashMap;

/**
 * @author sravan created on Aug 22, 2017
 *
 */

/*
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 */

// Inspired from https://leetcode.com/problems/two-sum/solution/

public class TwoSum {

	public int[] getTwoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement))
				return new int[] { i, map.get(complement) };
			map.put(nums[i], i);
		}
		return null;
	}

}
