package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sravan
 * Created on Mar 24, 2018
 */

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 * 
 * Find all strobogrammatic numbers that are of length = n.
 * 
 * For example, Given n = 2, return ["11","69","88","96"].
 * 
 * 
 */

public class StrobogramaticNumberII {
	public List<String> findStrobogrammatic(int n) {
		return helper(n, n);
	}

	private List<String> helper(int m, int n) {
		if (m == 0)
			return new ArrayList<>(Arrays.asList(""));
		if (m == 1)
			return new ArrayList<>(Arrays.asList("0", "1", "8"));

		List<String> list = helper(m - 2, n);
		List<String> res = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (m != n)
				res.add("0" + list.get(i) + "0");
			res.add("1" + list.get(i) + "1");
			res.add("8" + list.get(i) + "8");
			res.add("6" + list.get(i) + "9");
			res.add("9" + list.get(i) + "6");
		}
		return res;
	}
}
