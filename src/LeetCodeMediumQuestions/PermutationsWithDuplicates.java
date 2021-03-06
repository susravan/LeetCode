package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sravan created on Sep 26, 2017
 *
 */

/*
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [ [1,1,2],
 * [1,2,1], [2,1,1] ]
 *
 */

// Inspired from https://leetcode.com/problems/permutations/discuss/
public class PermutationsWithDuplicates {
	public List<List<Integer>> getPermutationsWithDuplicates(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums); // Important for the condition that is used to avoid duplicates in backtrack
							// method
		backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				// If the array is unsorted, we cannot use this condition
				if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
					continue;
				used[i] = true;
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, used);
				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
