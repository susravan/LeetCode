package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sravan
 * Given a collection of candidate numbers (C) and a target
 *         number (T), find all unique combinations in C where the candidate
 *         numbers sums to T.
 * 
 *         Each number in C may only be used once in the combination, there can
 *         be duplicates in the collection
 * 
 *         Note: All numbers (including target) will be positive integers. The
 *         solution set must not contain duplicate combinations. For example,
 *         given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, A solution
 *         set is: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 *
 * 
 */

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
				if (i > start && nums[i] == nums[i - 1]) // Skip duplicates
					continue;

				if (nums[i] <= rem) {
					tempList.add(nums[i]);
					// System.out.println("Adding " + nums[i] + " to the list");
					sumHelper(res, tempList, nums, rem - nums[i], i + 1);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}
}
