package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sravan created on Sep 25, 2017
 *
 */

/*
 * Given a collection of distinct numbers, return all possible currListutations.
 * 
 * For example, [1,2,3] have the following currListutations: [ [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 */

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		// Inserting a separate copy is required, as the arraylist is an object and
		// its address is passed when adding the list
		boolean[] visited = new boolean[nums.length];
		permuteHelper(nums, new ArrayList<>(), res, visited);
		return res;
	}

	private void permuteHelper(int[] nums, List<Integer> currList, List<List<Integer>> res, boolean[] visited) {
		if (currList.size() == nums.length) {
			res.add(new ArrayList<>(currList));
		} else {
			// If a number is visited, it means that number is already present in currList
			for (int i = 0; i < nums.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					currList.add(nums[i]);
					permuteHelper(nums, currList, res, visited);
					currList.remove(currList.size() - 1);
					visited[i] = false;
				}
			}
		}
	}
}
