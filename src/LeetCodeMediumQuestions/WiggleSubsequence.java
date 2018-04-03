package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Apr 3, 2018
 */

/**
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Examples:
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?
 */

// Inspired from 
public class WiggleSubsequence {
	public int wiggleMaxLength(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int len = nums.length;
		int up = 1, down = 1;
		
//		int[] up = new int[nums.length];
//		int[] down = new int[nums.length];
//		up[0] = 1;  down[0] = 1;
        
        // // O(N^2) time solution
        // for(int i=1; i < nums.length; i++) {
        //     for(int j=i-1; j >= 0; j--) {
        //         if(nums[i] > nums[j])
        //             up[i] = Math.max(up[i], down[j] + 1);
        //         else if(nums[i] < nums[j])
        //             down[i] = Math.max(down[i], up[j] + 1);
        //     }
        // }
        
//		// O(N) time solution, O(N) space
//		for (int i = 1; i < nums.length; i++) {
//			if (nums[i] > nums[i - 1])
//				up[i] = Math.max(up[i], down[i - 1] + 1);
//			else if (nums[i] < nums[i - 1])
//				down[i] = Math.max(down[i], up[i - 1] + 1);
//		}
		
		for(int i=1; i < nums.length; i++) {
			if(nums[i] > nums[i-1])
				up = Math.max(up, down+1);
			else if(nums[i] < nums[i-1])
				down = Math.max(down, up+1);
		}

		return Math.max(up, down);
    }
}
