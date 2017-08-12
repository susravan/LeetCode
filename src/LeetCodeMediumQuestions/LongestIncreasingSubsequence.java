package LeetCodeMediumQuestions;

import java.util.Arrays;

/**
 * @author sravan created on Aug 12, 2017
 *
 */

/*
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may
 * be more than one LIS combination, it is only necessary for you to return the
 * length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 */

// Inspired from https://leetcode.com/problems/longest-increasing-subsequence/solution/#approach-4-dynamic-programming-with-binary-searchaccepted

public class LongestIncreasingSubsequence {

	public int getLongestIncreasingSubsequence(int[] nums) {
		if (nums.length == 0)
			return 0;
		
		// O(n^2) time and O(n) space
		// Approach - Using DP - Maintaining an array which contains LIS length
		// including current element
		// For each index, check curr value with all elements before curr index
		// and use the memo array
		// to get the LIS length at previous index and add 1 to get the current
		// length if curr > prev, else 1
		int[] memo = new int[nums.length];
		memo[0] = 1;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j])
					memo[i] = Math.max(memo[i], memo[j] + 1);
				else
					memo[i] = Math.max(memo[i], 1);
			}
		}
		System.out.println(Arrays.toString(memo));
		int res = memo[0];
		for (int i = 0; i < memo.length; i++)
			res = Math.max(res, memo[i]);
		return res;
	}

}
