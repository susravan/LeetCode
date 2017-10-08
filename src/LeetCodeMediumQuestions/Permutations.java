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

	public List<List<Integer>> getcurrPermutations(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		currListuteHelper(nums, new ArrayList<Integer>(), res);
		return res;
	}

	private void currListuteHelper(int[] nums, List<Integer> currList, List<List<Integer>> res) {
		if (currList.size() == nums.length) {
			res.add(new ArrayList<>(currList)); // Inserting a separate copy is required as an arraylist is an object and
												// its address is passed when adding the list
		} else {
			// Assuming all elements in the given list are unique, check if the currList list
			// already contains the ith element in the array if contains skip calling
			// recursion on that otherwise select that and iterate over it
			for (int i = 0; i < nums.length; i++) {
				// This contains condition presence is mandatory. the start value condition that
				// is used in subsets problem doesn't work well here, as that would take given
				// fixed element as opposed to whichever element is not present.
				// Ex: second entry in the result would be [1,3,3] as opposed to [1,3,2]
				if (!currList.contains(nums[i])) {
					currList.add(nums[i]);
					currListuteHelper(nums, currList, res);
					currList.remove(currList.size() - 1);
				}
			}
		}
	}
}
