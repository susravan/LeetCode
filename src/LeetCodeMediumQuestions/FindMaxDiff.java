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
		if(arr.length < 2)
			return -1;
		
		int maxDiff = 0;
		int len = arr.length;
		int min = 0, max = 1;
		
		// Traverse the decresing part of the array and get to the min element
		while(min < len && max < len && arr[min] > arr[max]) {
			min++;
			max++;
		}
		// Update maxDiff with difference if min element is reached otherwise 0
		maxDiff = min < len && max < len ? arr[max] - arr[min] : 0;

		// Traverse from max term and update min and max values as seen, calculate diff
		int index = max+1;
		while(index < len) {
			if(arr[index] < arr[min]) {
				min = index;
				max = min;
			} else if(arr[index] > arr[max]) {
				max = index;
				maxDiff = Math.max(maxDiff, arr[max]-arr[min]);
			}
			index++;
		}
		
		return maxDiff;
	}
}
