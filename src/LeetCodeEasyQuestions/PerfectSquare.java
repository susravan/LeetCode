package LeetCodeEasyQuestions;

/**
 * @author sravan
 * 		   Given a positive integer num, write a function which returns
 *         True if num is a perfect square else False.
 * 
 *         Note: Do not use any built-in library function such as sqrt.
 * 
 *         Example 1:
 * 
 *         Input: 16 Returns: True Example 2:
 * 
 *         Input: 14 Returns: False
 */

public class PerfectSquare {
	public boolean isValidPerfectSquare(int num) {
		int lo = 1, high = num;
		
		while(lo <= high) {
			int mid = lo + (high - lo)/2;
			if(mid*mid == num)
				return true;
			else if(mid*mid > num)
				high = mid - 1;
			else
				lo = mid + 1;
		}
		return false;
	}
}
