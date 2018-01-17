package LeetCodeMediumQuestions;

/**
 * @author Sravan created on Aug 8, 2017
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

	public void nextPermutation(int[] nums) {
		// Find the least index from right that is lesser than it's right value
		int i = nums.length - 1;
		for (i = nums.length - 1; i >= 0; i--) {
			if (i == 0 || nums[i - 1] < nums[i])
				break;
		}

		// Edge case - if array is in descending order
		if (i == 0) {
			reverse(nums, 0);
			return;
		}

		// Swap next greater element to the changeNum and reverse the RHS part
		int changeNum = nums[i - 1];
		int j = nums.length - 1;
		while (j >= i) {
			if (nums[j] > changeNum)
				break;
			j--;
		}
		// swap i-1 with jth num
		int temp = nums[i - 1];
		nums[i - 1] = nums[j];
		nums[j] = temp;
		reverse(nums, i);
	}

	private void reverse(int[] nums, int start) {
		int end = nums.length - 1;
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

}
