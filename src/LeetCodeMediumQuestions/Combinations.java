package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sravan
 * Created on Jan 25, 2018
 */

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * 
 * [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 */

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (n < k || n == 0 || k == 0)
			return res;

		sumHelper(res, new ArrayList<Integer>(), n, 0, k);
		return res;
	}

	// "start" is required to skip already used elements
	private void sumHelper(List<List<Integer>> res, List<Integer> tempList, int n, int start, int k) {
		if (tempList.size() == k)
			res.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < n; i++) {
				tempList.add(i + 1);
				sumHelper(res, tempList, n, i + 1, k); // not k+1 as we can reuse the same element
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
