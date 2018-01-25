package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sravan
 * 		   Given an array S of n integers, are there elements a, b, c,
 *         and d in S such that a + b + c + d = target? Find all unique
 *         quadruplets in the array which gives the sum of target.
 * 
 *         Note: The solution set must not contain duplicate quadruplets.
 * 
 *         For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 *         A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 * 
 */

// Inspired from https://leetcode.com/problems/4sum/discuss/8575
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();

		int len = nums.length;
		if (len < 4)
			return res;

		Arrays.sort(nums);
		// System.out.println(Arrays.toString(nums));

		for (int i = 0; i < len - 3; i++) {
			// Below optimizations can be done to reduce the execution time in non-uniform
			// cases
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) // First number is too large
				break;
			if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) // First number is too small
				continue;
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			for (int j = i + 1; j < len - 2; j++) {
				if (nums[j] + nums[j + 1] + nums[j + 2] > target) // Second number is too large
					break;
				if (nums[j] + nums[len - 2] + nums[len - 1] < target) // Second number is too small
					continue;
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				// System.out.println("i = " + i + " j = " + j);
				int lo = j + 1, high = len - 1;
				while (lo < high) {
					// System.out.println(i + " " + j + " " + lo + " " + high);
					int sum = nums[i] + nums[j] + nums[lo] + nums[high];
					if (sum == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[high]));

						while (lo < high && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < high && nums[high] == nums[high - 1])
							high--;

						lo++;
						high--;
					} else if (sum < target)
						lo++;
					else
						high--;
				}
			}
		}
		return res;
	}
}
