package LeetCodeMediumQuestions;

import java.util.Collections;
import java.util.List;

/**
 * @author Sravan
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104

 */
public class KClosestElements {
	public List<Integer> getKClosestElements(List<Integer> arr, int k, int x) {
		int n = arr.size();
		if (x <= arr.get(0)) {
			return arr.subList(0, k);
		} else if (arr.get(n - 1) <= x) {
			return arr.subList(n - k, n);
		} else {
			int index = Collections.binarySearch(arr, x);
			if (index < 0)
				index = -index - 1;
			int low = Math.max(0, index - k - 1), high = Math.min(arr.size() - 1, index + k - 1);

			while (high - low > k - 1) {
				if (low < 0 || (x - arr.get(low)) <= (arr.get(high) - x))
					high--;
				else if (high > arr.size() - 1 || (x - arr.get(low)) > (arr.get(high) - x))
					low++;
				else
					System.out.println("unhandled case: " + low + " " + high);
			}
			return arr.subList(low, high + 1);
		}
	} 
}
