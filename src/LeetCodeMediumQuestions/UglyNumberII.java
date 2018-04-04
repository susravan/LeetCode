package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Apr 3, 2018
 */

/**
 * Write a program to find the n-th ugly number.
 * 
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number, and n does not exceed
 * 1690.
 */

// Inspired from
public class UglyNumberII {
	public int nthUgly(int n) {
		int[] memo = new int[n];
		memo[0] = 1;
		int factor2 = 2, factor3 = 3, factor5 = 5;
		int index2 = 1, index3 = 1, index5 = 1;

		for (int i = 1; i < n; i++) {
			memo[i] = Math.min(Math.min(factor2, factor3), factor5);
			System.out.println(factor2 + " " + factor3 + " " + factor5);
			if (factor2 == memo[i])
				factor2 = 2 * memo[index2++];
			if (factor3 == memo[i])
				factor3 = 3 * memo[index3++];
			if (factor5 == memo[i])
				factor5 = 5 * memo[index5++];
		}
		return memo[n - 1];
	}
}
