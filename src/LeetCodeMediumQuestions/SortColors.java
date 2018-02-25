package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 19, 2018
 */

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * click to show follow up.
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using
 * counting sort. First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 *
 */

// Inspired from https://leetcode.com/problems/sort-colors/discuss/
public class SortColors {
	public int[] sortColors(int[] nums) {
		// 1-pass algo. 2-pass would be taking counts of each and overwriting the array
		// p0 - last zero index, p2 - first 2 index, index - moves from 0 to p2 included
		int p0 = 0, p2 = nums.length - 1, index = 0;
		while (index <= p2) {
			if (nums[index] == 0) {
				nums[index] = nums[p0];
				nums[p0] = 0;
				p0++;
			}
			else if (nums[index] == 2) {
				nums[index] = nums[p2];
				nums[p2] = 2;
				p2--;
			}
			else
				index++;
		}
		return nums;
	}
}
