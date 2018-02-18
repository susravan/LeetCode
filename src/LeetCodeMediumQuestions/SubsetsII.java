package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sravan
 * Created on Feb 17, 2018
 */

/**
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,2], a solution is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */

public class SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();

		subsetWithDupHelper(res, new ArrayList<>(), nums, 0);
		return res;
	}

	private void subsetWithDupHelper(List<List<Integer>> res, List<Integer> currSet, int[] nums, int start) {
		res.add(new ArrayList<>(currSet));

		// Because there are duplicates in the given array and we dont need duplicates
		// in the subsets, we remove them in the below extra if condition
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1])
				continue;

			currSet.add(nums[i]);
			subsetWithDupHelper(res, currSet, nums, i + 1);
			currSet.remove(currSet.size() - 1);
		}
	}
}
