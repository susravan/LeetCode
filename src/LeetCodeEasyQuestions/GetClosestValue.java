package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Apr 20, 2018
 */

/**
 * Given a non-empty binary search tree and a target value, find the value in
 * the BST that is closest to the target.
 * 
 * Note: Given target value is a floating point. You are guaranteed to have only
 * one unique value in the BST that is closest to the target.
 */

public class GetClosestValue {
	public int getClosestVal(TreeNode root, double target) {
		if (root == null)
			return 0;

		int res = root.val;
		while (root != null) {
			if (Math.abs(target - root.val) < Math.abs(target - res))
				res = root.val;
			root = root.val > target ? root.left : root.right;
		}
		return res;
	}
}
