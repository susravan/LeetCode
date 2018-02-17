package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sravan
 * Created on Feb 17, 2018
 */

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 */

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> occurMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			occurMap.put(nums[i], occurMap.getOrDefault(nums[i], 0) + 1);
		}

		// Bucket sort logic
		List<Integer>[] arrList = new List[nums.length + 1]; // Since num of occurances is directly mapped to index in
																// arrList, maxOccurances = array length which comes to
																// array length's index => arrList's size should be 1
																// more that array's length
		for (int numOccured : occurMap.keySet()) {
			int occurances = occurMap.get(numOccured);
			if (arrList[occurances] == null)
				arrList[occurances] = new ArrayList<>();
			arrList[occurances].add(numOccured); // Partition nums based on the no. of times they occured
		}

		for (int i = arrList.length - 1; i >= 0 && res.size() < k; i--) {
			if (arrList[i] != null)
				res.addAll(arrList[i]);
		}
		return res.subList(0, Math.min(res.size(), k));
	}
}
