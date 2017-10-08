package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sravan created on Oct 7, 2017
 *
 */

/*
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,3], a solution is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 *
 */

// Inspired from
public class Subsets {

	public List<List<Integer>> getSubsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();

		subsetsHelper(nums, 0, new ArrayList<>(), res);

		return res;
	}

	private void subsetsHelper(int[] nums, int start, List<Integer> currList, List<List<Integer>> res) {
		// Normally in backtracking solutions, we will have a base condition to return
		// or interting a list into another list, but in this case, as we dont have
		// any fixed length on the size of the lists, there is no condition like that.
		// The idea is to insert all the lists that we form by inserting one element at
		// a time.
		// Note that on this problem, we dont consider any order of elements.
		res.add(new ArrayList<>(currList));
		for (int i = start; i < nums.length; i++) {
			// Add each element in the array to the list - to do this, add the element first
			// call next iteration and then remove the element to insert the next one
			currList.add(nums[i]);
			subsetsHelper(nums, i + 1, currList, res);
			currList.remove(currList.size() - 1);
		}
	}

}
