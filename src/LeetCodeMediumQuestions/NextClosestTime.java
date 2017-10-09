package LeetCodeMediumQuestions;

import java.util.Arrays;

/**
 * @author sravan created on Sep 27, 2017
 *
 */

/*
 * Given a time represented in the format "HH:MM", form the next closest time by
 * reusing the current digits. There is no limit on how many times a digit can
 * be reused.
 * 
 * You may assume the given input string is always valid. For example, "01:34",
 * "12:09" are all valid. "1:34", "12:9" are all invalid.
 * 
 * Example 1:
 * 
 * Input: "19:34" Output: "19:39" Explanation: The next closest time choosing
 * from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later. It is not
 * 19:33, because this occurs 23 hours and 59 minutes later. Example 2:
 * 
 * Input: "23:59" Output: "22:22" Explanation: The next closest time choosing
 * from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is
 * next day's time since it is smaller than the input time numerically. Discuss
 *
 * 
 * 
 */

// Inspired from
public class NextClosestTime {

	public String getNextClosestTime(String time) {
		String res = "";
		int hrs = Integer.parseInt(time.split(":")[0]);
		int min = Integer.parseInt(time.split(":")[1]);
		int[] sortedNums = new int[] { hrs / 10, hrs % 10, min / 10, min % 10 };
		Arrays.sort(sortedNums);
		// System.out.println(Arrays.toString(sortedNums));
		int leastDigit = sortedNums[0];

		int index = 0;
		while (index < sortedNums.length) {
			if (min % 10 < sortedNums[index]) {
				min += (sortedNums[index] - (min % 10));
				return preserveZero(hrs + ":" + min);
			}
			index++;
		}

		index = 0;
		while (index < sortedNums.length) {
			if (sortedNums[index] < 6 && min / 10 < sortedNums[index]) {
				// System.out.println("min/10 = " + min/10 + " sortedNums = " +
				// sortedNums[index]);
				min = (sortedNums[index]) * 10 + leastDigit;
				return preserveZero(hrs + ":" + min);
			}
			index++;
		}

		// first digit of hrs
		index = 0;
		while (index < sortedNums.length) {
			if (hrs % 10 < sortedNums[index]) {
				int temp = hrs;
				hrs += (sortedNums[index] - (hrs % 10));
				if (hrs < 24)
					return preserveZero(hrs + ":" + leastDigit + leastDigit);
				else
					hrs = temp;
			}
			index++;
		}

		index = 0;
		while (index < sortedNums.length) {
			if (sortedNums[index] < 3 && hrs / 10 < sortedNums[index]) {
				hrs = (sortedNums[index] - hrs / 10) * 10 + leastDigit;
				return preserveZero(hrs + ":" + leastDigit + leastDigit);
			}
			index++;
		}

		return preserveZero(leastDigit + "" + leastDigit + ":" + leastDigit + "" + leastDigit);
	}

	private String preserveZero(String str) {
		int hrsTenPosition = Integer.parseInt(str.split(":")[0]);
		int minTenPosition = Integer.parseInt(str.split(":")[1]);

		return "" + hrsTenPosition / 10 + hrsTenPosition % 10 + ":" + minTenPosition / 10 + minTenPosition % 10;
	}

}
