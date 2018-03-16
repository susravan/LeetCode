package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Sravan
 * Created on Mar 15, 2018
 */

/**
 * Given an integer array, your task is to find all the different possible
 * increasing subsequences of the given array, and the length of an increasing
 * subsequence should be at least 2 .
 * 
 * Example: Input: [4, 6, 7, 7] Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7,
 * 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]] Note: The length of the given array
 * will not exceed 15. The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be
 * considered as a special case of increasing sequence.
 */

// Inspired from
// https://leetcode.com/problems/increasing-subsequences/discuss/97147/Java-solution-beats-100
public class IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		helper(new LinkedList<>(), 0, nums, res);
		return res;
	}

	private void helper(LinkedList<Integer> list, int start, int[] nums, List<List<Integer>> res) {
		if (list.size() >= 2) {
			res.add(new ArrayList<>(list));
		}
		// Using set to avoid duplicates even when the array is not sorted
		Set<Integer> set = new HashSet<>();
		for (int i = start; i < nums.length; i++) {
			if (set.contains(nums[i]))
				continue;

			if (list.size() == 0 || nums[i] >= list.peekLast()) {
				set.add(nums[i]);
				list.add(nums[i]);
				helper(list, i + 1, nums, res);
				list.pollLast();
			}
		}
	}
}
