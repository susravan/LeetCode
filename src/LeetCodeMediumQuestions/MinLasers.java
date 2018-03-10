package LeetCodeMediumQuestions;

import java.util.HashMap;
import java.util.List;

/**
 * @author Sravan
 * Created on Mar 10, 2018
 */

/**
 * You are at origin (0,0) and required to find minimum number of lasers you
 * would require to point light on all the statues given at coordinates other
 * than origin. The statues are glass ones and rays pass through them in
 * straight lines to the other side.
 */

// Inspired from
public class MinLasers {
	public int getMinLasers(List<Point2D> list) {
		if (list.size() < 2)
			return list.size();

		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

		for (int i = 0; i < list.size(); i++) {
			Point2D curr = list.get(i);
			int slopeY = curr.y;
			int slopeX = curr.x;
			if (slopeX == 0 && slopeY == 0)
				continue;
			int gcd = gcd(Math.abs(slopeX), Math.abs(slopeY));
			slopeY /= gcd;
			slopeX /= gcd;
			// Add slopeX and slopeY
			if (!map.containsKey(slopeX)) {
				HashMap<Integer, Integer> temp = new HashMap<>();
				temp.put(slopeY, 1);
				map.put(slopeX, temp);
			} else {
				if (!map.containsKey(slopeY)) {
					HashMap<Integer, Integer> temp = map.get(slopeX);
					temp.put(slopeY, 1);
				}
			}
		}

		int count = 0;
		for (int key : map.keySet()) {
			count += map.get(key).size();
		}
		return count;
	}

	private int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}

class Point2D {
	int x, y;

	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
