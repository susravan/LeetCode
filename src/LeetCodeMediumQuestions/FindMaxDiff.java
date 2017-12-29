package LeetCodeMediumQuestions;

/**
 * @author sravan
 * 		   Given an array of elements, find the maximum difference
 *         between the least and greatest element, except that greater element
 *         should always be at higher index than lower element.
 */

// Asked in Paypal Phone interview
public class FindMaxDiff {
	public int getmaxDiff(int[] arr) {
		if (arr == null || arr.length == 0)
			return 0;

		// Approach: Store min value as we traverse the array. Maintain 2 pointers left
		// and right to see if the values are increasing or decreasing - this gives us
		// wheather to change the min value or not. Note that only if the right > left,
		// we change the min value. Otherwise if the last element is the min value, it
		// wouldn't effect our result.
		int left = 0, right = 1, minIndex = 0;
		int max_diff = Integer.MIN_VALUE;

		while (right < arr.length) {
			if (arr[left] < arr[right]) {
				if (arr[minIndex] > arr[left]) {
					minIndex = left;
				}
				max_diff = Math.max(max_diff, arr[right] - arr[minIndex]);
			}
			left++;
			right++;
		}
		return max_diff;
	}
}
