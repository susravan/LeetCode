package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sravan created on Sep 25, 2017
 *
 */

/*
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [ [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 *
 */

public class Permutations {

	public List<List<Integer>> getPermutations(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		res = permuteHelper(nums, new ArrayList<Integer>(), res);
		return res;
	}

	private List<List<Integer>> permuteHelper(int[] nums, List<Integer> perm, List<List<Integer>> res) {
		if (perm.size() == nums.length) {
			res.add(new ArrayList<>(perm)); // ing a separate copy is required as an arraylist is an object and its
											// address is passed when adding the list
			return res; // This return res goes to previous permuteHelper but not to getPermutations
						// method
		}

		// Assuming all elements in the given list are unique, check if the perm list
		// already contains the ith element in the array if contains skip calling
		// recursion on that otherwise select that and iterate over it
		for (int i = 0; i < nums.length; i++) {
			if (!perm.contains(nums[i])) {
				perm.add(nums[i]);
				res = permuteHelper(nums, perm, res);
				perm.remove(perm.size() - 1);
			}
		}
		return res;
	}
}
