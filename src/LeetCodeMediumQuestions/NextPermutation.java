package LeetCodeMediumQuestions;

import java.util.Arrays;

/**
 * @author sravan created on Aug 8, 2017
 *
 */

/*
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 1,2,3 → 1,3,2 3,2,1 →
 * 1,2,3 1,1,5 → 1,5,1
 *
 */

public class NextPermutation {

	public void getNextPermutation(int[] nums) {
		if (nums.length < 2)
			return;

		int index = nums.length - 1;
		while (index > 0) {
			if (nums[index] > nums[index - 1]) {
				break;
			}
			index--;
		}

		// Array is in descending order
		if (index == 0) {
			Arrays.sort(nums);
			return;
		}

		// Find immediate char greater than chrNums[index - 1]
		int rep = nums[index - 1];
		int minIndex = index;

		for (int i = index; i < nums.length; i++) {
			if (nums[i] > rep && nums[minIndex] > nums[i]) {
				minIndex = i;
			}
		}

		// Swap both the characters
		int replace = nums[index - 1];
		nums[index - 1] = nums[minIndex];
		nums[minIndex] = replace;

		// Sorting all other characters
		Arrays.sort(nums, index, nums.length);
	}

}
