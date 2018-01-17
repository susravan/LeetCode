package LeetCodeMediumQuestions;

/**
 * @author Sravan 
 * Divide two integers without using multiplication, division and
 *         mod operator.
 * 
 *         If it is overflow, return MAX_INT.
 *
 * 
 */

// Inspired from 
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		int sign = 1;
		
		if(dividend < 0 && divisor > 0 || divisor < 0 && dividend > 0)
			sign = -1;
		
		long ldividend = Math.abs((long) dividend);
		long ldivisor = Math.abs((long) divisor);
		
		if (ldivisor == 0) return Integer.MAX_VALUE;
		if ((ldividend == 0) || (ldividend < ldivisor))	return 0;
		
		long quotient = divideHelper(ldividend, ldivisor);

		if(quotient > Integer.MAX_VALUE)
			return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		else
			return (int) (sign * quotient);
	}
	
	private long divideHelper(long ldividend, long ldivisor) {
		if(ldividend < ldivisor)
			return 0;
		
		long quotient = 1;
		long sum = ldivisor;
		
		while(sum + sum <= ldividend) {
			sum += sum;
			quotient += quotient;
		}
		return quotient + divideHelper(ldividend - sum, ldivisor);
	}
}
