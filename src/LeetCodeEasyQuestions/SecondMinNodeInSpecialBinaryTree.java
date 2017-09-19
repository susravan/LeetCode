package LeetCodeEasyQuestions;

/**
 * @author sravan
 * created on Sep 2, 2017
 *
 */

/* Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 *
 */

// Inspired from 
public class SecondMinNodeInSpecialBinaryTree {

	public int findSecondMinNodeInSpecialBinaryTree(TreeNode root) {
		if(root.left == null && root.right == null)
			return -1;
		if(root.left.val == root.right.val) {
            if(root.left.val == root.val)
                return -1;
            else
                return root.left.val;
        }
		int left = findSecondMinNodeInSpecialBinaryTreeHelper(root.left, root.val);
		int right = findSecondMinNodeInSpecialBinaryTreeHelper(root.right, root.val);
		int prev = root.val;
		if(left == prev && right == prev)
            return Integer.MAX_VALUE;
        else if(left == prev)
            return right;
        else if(right == prev)
            return left;	
        else
            return Math.min(left,  right);
	}
	
	private int findSecondMinNodeInSpecialBinaryTreeHelper(TreeNode root, int prev) {
		if(root.left == null && root.right == null)
			return root.val;
		if(root.val == prev) {
			int left = findSecondMinNodeInSpecialBinaryTreeHelper(root.left, prev);
			int right = findSecondMinNodeInSpecialBinaryTreeHelper(root.right, prev);
			if(left == prev && right == prev)
				return Integer.MAX_VALUE;
			else if(left == prev)
				return right;
			else if(right == prev)
				return left;	
			else
				return Math.min(left,  right);
		}
		else
			return root.val;
	}

}
