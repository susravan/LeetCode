package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 27, 2018
 */

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 */

// Inspired from
public class MinInRotatedSortedArray {
	public int findMin(int[] arr) {
		int lo = 0, high = arr.length - 1;

		while (lo < high) {
			int mid = lo + (high - lo) / 2;
			// min lies in left part
			if (arr[mid] < arr[high])
				high = mid;
			else
				lo = mid + 1; // +1 - as arr[lo] is greater than one element, we can be sure that it cannot be
								// min of the array
		}
		return arr[lo]; // lo points the last element in the last iteration
	}
}
