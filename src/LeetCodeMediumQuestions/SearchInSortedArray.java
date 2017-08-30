package LeetCodeMediumQuestions;

public class SearchInSortedArray {

	public int searchInSortedArray(int[] nums, int target) {
		int len = nums.length;

		if (nums.length == 0)
			return -1;

		int left = 0, right = len - 1;

		// Start as normal binary search
		while (left <= right) {
			int mid = left + (right - left) / 2;
			// System.out.println("left = " + left + " right = " + right + " mid
			// = " + mid);
			if (nums[mid] == target)
				return mid;
			// Right half of array is sorted
			else if (nums[mid] <= nums[right]) {
				// Target lies in sorted part
				if (nums[mid] < target && target <= nums[right])
					left = mid + 1;
				else
					right = mid - 1;
			}
			// Left half of array is sorted
			else {
				// Target lies in sorted part
				if (nums[left] <= target && target < nums[mid])
					right = mid - 1;
				else
					left = mid + 1;
			}
		}
		return -1;
	}

}
