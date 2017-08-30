package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		// System.out.println(Arrays.toString(nums));
		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			// Results for same sum should not be duplicated
			if (i == 0 || (nums[i] != nums[i - 1])) {
				int target = -nums[i];
				// System.out.println("target = " + target);
				int start = i + 1, end = nums.length - 1;
				while (start < end) {
					// System.out.println("i = " + i + " start = " + start + "
					// end = " + end);
					if (nums[start] + nums[end] > target)
						end--;
					else if (nums[start] + nums[end] < target)
						start++;
					else {
						res.add(Arrays.asList(nums[start], nums[end], nums[i]));
						// Duplicate numbers should not be added to the result
						while (start < end && nums[start] == nums[start + 1])
							start++;
						while (start < end && nums[end] == nums[end - 1])
							end--;
						start++;
						end--;
					}
					// System.out.println(res);
				}
			}
		}
		return res;
	}

}
