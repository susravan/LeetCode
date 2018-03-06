package LeetCodeDifficultQuestions;

import java.util.Arrays;

/**
 * @author Sravan
 * Created on Mar 5, 2018
 */

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 */

public class Candy {
	public int candy(int[] ratings) {
		int[] candies = new int[ratings.length];
		candies[0] = 1;

		// First take care of left condition only
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				candies[i] = candies[i - 1] + 1;
			else
				candies[i] = 1;
		}

		int totalCandies = candies[candies.length - 1];

		// Now take care of second condition and update the candies array and sum
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				candies[i] = Math.max(candies[i], candies[i + 1] + 1);
			totalCandies += candies[i];
		}
		// System.out.println(Arrays.toString(candies));
		return totalCandies;
	}
}
