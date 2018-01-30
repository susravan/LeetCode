package LeetCodeEasyQuestions;

/**
 * @author Sravan
 * Created on Jan 29, 2018
 */

/**
 * Write a function that takes an unsigned integer and returns the number of ’1'
 * bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 *
 */

public class NumberOfOnes {
	// you need to treat n as an unsigned value
	public int hammingWeightEfficient(int n) {
		// Approach: Subtracting 1 changes the LSb 1 bit to 0 => run while loop until n
		// == 0, no. of iterations = no. of ones
		int count = 0;

		while (n != 0) {
			n &= (n - 1);
			count++;
		}
		return count;
	}

	public int hammingWeightNormal(int n) {
		int count = 0, shiftCount = 0;
		// Shift the bits and count ones
		while (shiftCount < 32) {
			if ((n & 1) == 1) {
				count++;
			}
			n >>= 1;
			shiftCount++;
		}
		return count;
	}
}
