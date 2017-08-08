package LeetCodeMediumQuestions;

import java.util.Arrays;

/**
 * @author sravan created on Aug 8, 2017
 *
 */

/*
 * Given a positive 32-bit integer n, you need to find the smallest 32-bit
 * integer which has exactly the same digits existing in the integer n and is
 * greater in value than n. If no such positive 32-bit integer exists, you need
 * to return -1.
 * 
 * Example 1: Input: 12 Output: 21 Example 2: Input: 21 Output: -1
 *
 */

// Inspired from https://leetcode.com/problems/next-greater-element-iii/discuss/

public class NextGreaterElement3 {

	public int getNextGreaterElement3(int n) {
		char[] numArr = Integer.toString(n).toCharArray();
		if (numArr.length < 2)
			return -1;

		int index = numArr.length - 1;
		while (index > 0) {
			if (numArr[index] > numArr[index - 1])
				break;
			index--;
		}

		// If the integer contains digits in descending order
		if (index == 0)
			return -1;

		// Get the smallest number greater than the replaceNum to the right of
		// the number
		int replaceIndex = index - 1;
		int smallest = index;
		while (index < numArr.length) {
			if (numArr[index] > numArr[replaceIndex] && numArr[smallest] > numArr[index])
				smallest = index;
			index++;
		}

		// Swap elements
		char temp = numArr[replaceIndex];
		numArr[replaceIndex] = numArr[smallest];
		numArr[smallest] = temp;

		// Sort remaining digits
		Arrays.sort(numArr, replaceIndex + 1, numArr.length);

		// Since the result is stored in string format, directly converting it
		// to integer can result in stack overflow (Eg: 7214748364)
		// To avoid that we use this precaution
		long res = Long.parseLong(new String(numArr));
		return (res <= Integer.MAX_VALUE) ? (int) res : -1;
	}

}
