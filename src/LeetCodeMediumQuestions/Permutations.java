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
		List<Integer> numsList = new ArrayList<>();
		for (int num : nums)
			numsList.add(num);

		List<Integer> tempList = new ArrayList<>();

		res = permuteHelper(numsList, tempList, res);
		return res;
	}

	private List<List<Integer>> permuteHelper(List<Integer> numList, List<Integer> perm, List<List<Integer>> res) {
		if (numList.size() == 0) {
			res.add(new ArrayList<>(perm)); // ing a separate copy is required as an arraylist is an object and its
											// address is passed when adding the list
			return res; // This return res goes to previous permuteHelper but not to getPermutations
						// method
		}

		for (int i = 0; i < numList.size(); i++) {
			int currNum = numList.remove(i);
			perm.add(currNum);
			res = permuteHelper(numList, perm, res);
			perm.remove(perm.size() - 1);
			numList.add(i, currNum);
		}
		return res;
	}
}
