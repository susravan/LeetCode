package LeetCodeEasyQuestions;

/**
 * @author sravan created on Oct 7, 2017
 *
 */

/*
 * Given a positive integer, check whether it has alternating bits: namely, if
 * two adjacent bits will always have different values.
 * 
 * Example 1: Input: 5 Output: True Explanation: The binary representation of 5
 * is: 101
 * Example 2: Input: 7 Output: False Explanation: The binary
 * representation of 7 is: 111.
 * Example 3: Input: 11 Output: False Explanation:
 * The binary representation of 11 is: 1011.
 * Example 4: Input: 10 Output: True
 * Explanation: The binary representation of 10 is: 1010.
 *
 */

public class BinaryNumWithAlternatingBits {

	public boolean hasAlternatingBits(int n) {
		// Get last 2 bits of the integer
		int flag = (n & 3);
        if(flag == 3 || flag == 0)
            return false;
        // Compare last 2 bits with the flag obtained (01 || 10)
        while(n != 0) {
            if(((n & 3) ^ flag) != 0)
                return false;
            else
                n = (n >> 2);
        }
        return true;
	}

}
