package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sravan 
 * Given a set of candidate numbers (C) (without duplicates) and
 *         a target number (T), find all unique combinations in C where the
 *         candidate numbers sums to T.
 * 
 *         The same repeated number may be chosen from C unlimited number of
 *         times.
 * 
 *         Note: All numbers (including target) will be positive integers. The
 *         solution set must not contain duplicate combinations. For example,
 *         given candidate set [2, 3, 6, 7] and target 7, A solution set is: [
 *         [7], [2, 2, 3] ]
 *
 * 
 */

// Inspired from https://leetcode.com/problems/combination-sum/discuss/16502
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();

		// Start is a required parameter which otherwise would result in duplicate list
		// of numbers in the result
		sumHelper(res, new ArrayList<Integer>(), candidates, target, 0);
		return res;
	}

	private void sumHelper(List<List<Integer>> res, List<Integer> tempList, int[] nums, int rem, int start) {
		if (rem < 0)
			return;
		if (rem == 0) {
			res.add(new ArrayList<Integer>(tempList));
		} else {
			for (int i = start; i < nums.length; i++) {
				if (nums[i] <= rem) {
					tempList.add(nums[i]);
					// System.out.println("Adding " + nums[i] + " to the list");
					sumHelper(res, tempList, nums, rem - nums[i], i);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}
}
