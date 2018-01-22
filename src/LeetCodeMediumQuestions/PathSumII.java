package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sravan
 * Created on Jan 22, 2018
 */

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */

public class PathSumII {
	// DFS - if currSum == reqSum, add node.val into tempList, tempList to res,
	// remove node.val from currList and return
	// else add node.val to currList and pass it to left and right
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();

		pathSumHelper(root, sum, res, new ArrayList<>());
		return res;
	}

	private void pathSumHelper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> currList) {
		if (root == null)
			return;

		if (root.left == null && root.right == null && root.val == sum) {
			currList.add(root.val);
			res.add(new ArrayList<>(currList));
			currList.remove(currList.size() - 1);
			return;
		}

		currList.add(root.val);
		pathSumHelper(root.left, sum - root.val, res, currList);
		pathSumHelper(root.right, sum - root.val, res, currList);
		currList.remove(currList.size() - 1);
	}
}
