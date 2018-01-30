package LeetCodeMediumQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sravan
 * Created on Jan 29, 2018
 */

/**
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in
 * parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5". Given numerator = 2,
 * denominator = 1, return "2". Given numerator = 2, denominator = 3, return
 * "0.(6)".
 */

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0)
			return "";
		if (numerator == 0)
			return "0";

		StringBuilder sb = new StringBuilder();
		sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
		// long required remainder (here num) is multiplied by 10 until it forms a
		// divisible number where as divisor can be Integer.MAX_VALUE
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);

		// Add left side of decimal first
		sb.append(num / den);
		num %= den;

		if (num == 0)
			return sb.toString();

		sb.append(".");
		// Use map to store the remainders and it's index. Use this map to put brackets
		// if remainders are repeated
		Map<Long, Integer> map = new HashMap<>();
		map.put(num, sb.length());

		while (num != 0) {
			num *= 10;
			sb.append(num / den);
			num %= den;
			if (map.containsKey(num)) {
				sb.insert(map.get(num), "(");
				sb.append(")");
				break;
			} else {
				// Push remainder to map
				map.put(num, sb.length());
			}
		}
		return sb.toString();
	}
}
