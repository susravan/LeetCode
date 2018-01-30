package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Jan 30, 2018
 */

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 *
 */

// Inspired from
// https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/56721/
public class BitwiseAND {
	public int rangeBitwiseAnd(int m, int n) {
		// Approach:
		// Given m < n,
		// m := common bits + 0 + remaining bits of m
		// n := common bits + 1 + remaining bits of n.
		// thus repeatedly clear last bit of n, until n > m
		while (m < n) {
			n &= n - 1;
		}
		return n;
	}
}
