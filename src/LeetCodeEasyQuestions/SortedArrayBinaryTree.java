package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Jan 21, 2018
 */

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

public class SortedArrayBinaryTree {
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length < 1)
            return null;
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int low, int high) {
        if(low > high)
            return null;
        
        int mid = low + (high-low)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, low, mid - 1);
        root.right = helper(nums, mid + 1, high);
        return root;
    }
}
