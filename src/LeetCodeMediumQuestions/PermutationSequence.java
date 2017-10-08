package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sravan created on Oct 7, 2017
 *
 */

/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 *
 */

// Inspired from https://leetcode.com/problems/permutation-sequence/discuss/
public class PermutationSequence {

	public String getPermutationSequence(int n, int k) {
		// Construct numbers list
		List<Integer> numList = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			numList.add(i);
		}

		// Construct factorial lookup
		int[] factArr = new int[n + 1];
		factArr[0] = 1;

		for (int i = 1; i < factArr.length; i++) {
			factArr[i] = factArr[i - 1] * i;
		}

		k--; // Zero based index
		StringBuilder sb = new StringBuilder();

		// Start dividing "k" from (n-1)! till 1! and update k each time
		for (int i = 1; i <= n; i++) {
			int index = k / factArr[n - i];
			sb.append(numList.get(index));
			numList.remove(index);
			k -= index * factArr[n - i];
		}

		return sb.toString();
	}
}
