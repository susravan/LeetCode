package LeetCodeMediumQuestions;

/**
 * @author sravan
 * created on Aug 7, 2017
 *
 */

/* Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.
 *
 */

// Inspired from 
public class MaximumBinaryTree {

	public TreeNode maximumBinaryTree(int[] nums) {
		return constructMaxBT(nums, 0, nums.length - 1);
	}
	
	private TreeNode constructMaxBT(int[] nums, int start, int end) {
        // start > end => no valid integer in the array to create a node 
        if(start > end)
            return null;
            
        int maxNum = Integer.MIN_VALUE, maxIndex = 0;
        for(int i=start; i <= end; i++) {
            if(nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        // System.out.println("maxNum = " + maxNum);
        // System.out.println("start = " + start + " end = " + end);
        TreeNode root = new TreeNode(maxNum);
        root.left = constructMaxBT(nums, start, maxIndex - 1);
        root.right = constructMaxBT(nums, maxIndex + 1, end);
        return root;
    }
}
