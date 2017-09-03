package LeetCodeMediumQuestions;

/**
 * @author sravan
 * created on Sep 2, 2017
 *
 */

/* Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]
 *
 */


public class MaximumSwap {

	public int getMaximumSwap(int num) {
		String res = getMaximumSwapHelper(Integer.toString(num));
		return Integer.parseInt(res);
	}

	private String getMaximumSwapHelper(String num) {
		// Base case
		if(num.length() == 1)
			return num;
		
		// Get the highest number
		char[] chrArr = num.toCharArray();
		char maxNum = 0;
		int maxIndex = 0;
		for (int i = chrArr.length - 1; i >= 0; i--) {
			if (chrArr[i] > maxNum) {
				maxNum = chrArr[i];
				maxIndex = i;
			}
		}
		
		// Look for the first number less than maximum from left
		int index = 0;
		while (chrArr[index] == maxNum) {
			index++;
			if (index >= chrArr.length)
				return num;
		}

		// If swap element index <= maxIndex
		if (index <= maxIndex) {
			System.out.println("Swapping the indexes " + index + " with " + maxIndex);
			char temp = chrArr[index];
			chrArr[index] = chrArr[maxIndex];
			chrArr[maxIndex] = temp;
			System.out.println("After swapping = " + new String(chrArr));
			return new String(chrArr);
		}
		// Recurse with non-max substring
		else {
			String temp = num.substring(index);
			System.out.println("temp = " + temp);
			String partialLargestNum = getMaximumSwapHelper(temp);
			String res = num.substring(0, index) + partialLargestNum;
			return res;
		}
	}
}
