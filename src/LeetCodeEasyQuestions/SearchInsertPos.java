package LeetCodeEasyQuestions;

/**
 * @author sravan created on Aug 11, 2017
 *
 */

/*
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples. [1,3,5,6], 5 → 2 [1,3,5,6], 2 → 1 [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 * 
 */

// Inspired from
public class SearchInsertPos {

	public int getInsertPos(int[] nums, int target) {
		if (nums.length == 0)
			return 0;
		int low = 0, high = nums.length - 1;

		// Similar to iterative binary search
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		// Comes out of the loop when high < low, to get the
		// index that needs to be inserted, return higher index = low
		return low;
	}

}
