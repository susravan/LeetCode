package LeetCodeDifficultQuestions;

/**
 * @author Sravan
 * Created on Jan 27, 2018
 */

/**
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose an array
 * sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 */

// Inspired from
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/discuss/48808
public class MinRotatedSortedArrWithDup {
	public int findMin(int[] nums) {
		int lo = 0, high = nums.length - 1;

		while (lo < high) {
			int mid = lo + (high - lo) / 2;
			if (nums[mid] < nums[high])
				high = mid;
			else if (nums[mid] > nums[high])
				lo = mid + 1;
			else {
				high--;
			}
		}
		return nums[lo];
	}
}
