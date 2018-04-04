package LeetCodeMediumQuestions;

import java.util.PriorityQueue;

/**
 * @author Sravan
 * Created on Apr 3, 2018
 */

/**
 * Write a program to find the nth super ugly number.
 * 
 * Super ugly numbers are positive numbers whose all prime factors are in the
 * given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16,
 * 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given
 * primes = [2, 7, 13, 19] of size 4.
 * 
 * Note: (1) 1 is a super ugly number for any given primes. (2) The given
 * numbers in primes are in ascending order. (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 <
 * primes[i] < 1000. (4) The nth super ugly number is guaranteed to fit in a
 * 32-bit signed integer.
 */

// Inspired from
public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		PriorityQueue<Number> q = new PriorityQueue<>();
		int[] memo = new int[n];
		memo[0] = 1;

		for (int i = 0; i < primes.length; i++)
			q.offer(new Number(primes[i], primes[i], 1));

		for (int i = 1; i < n; i++) {
			memo[i] = q.peek().val;
			while (memo[i] == q.peek().val) {
				Number curr = q.poll();
				q.offer(new Number(curr.prime * memo[curr.idx], curr.prime, curr.idx + 1));
			}
		}
		return memo[n - 1];
	}

	class Number implements Comparable<Number> {
		int val, prime, idx;

		public Number(int val, int prime, int idx) {
			this.val = val;
			this.prime = prime;
			this.idx = idx;
		}

		@Override
		public int compareTo(Number o) {
			return this.val - o.val;
		}
	}
}
