package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Feb 14, 2018
 */

/**
 * Assume you have an array of length n initialized with all 0's and are given k
 * update operations.
 * 
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which
 * increments each element of subarray A[startIndex ... endIndex] (startIndex
 * and endIndex inclusive) with inc.
 * 
 * Return the modified array after all k operations were executed.
 */

// Inspired from
// https://www.programcreek.com/2014/07/leetcode-range-addition-java/
public class RangeAddition {
	// O(N) solution - Mark the ranges in first iteration, update values in the
	// second
	public int[] getModifiedArray(int arrLen, int[][] updates) {
		// Step 1: Mark the ranges in the array
		int[] result = new int[arrLen];
		for(int i=0; i < updates.length; i++) {
			result[updates[i][0]] += updates[i][2];
			if(updates[i][1] < arrLen-1)
				result[updates[i][1] + 1] -= updates[i][2];
		}

		// Step 2: Update result with cummulative values
		int cumm = 0;
		for(int i=0; i < arrLen; i++) {
			cumm += result[i];
			result[i] = cumm;
		}
		return result;
	}
}
