package LeetCodeMediumQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author sravan created on Sep 24, 2017
 *
 */

/*
 * Given a series of inputs as below, filter the output according to the given
 * range of dates in the first line and merge the values on monthly basis
 * 
 * Input: 2014-05, 2016-02
 * 
 * 2014-05-12, clicks, 230 2016-09-09, clicks, 400 2014-05-19, app_installs, 12
 * 2014-05-01, clicks, 120 2015-04-13, retweets, 101
 * 
 * Output: 2015-04, retweets, 101 2014-05, app_installs, 12, clicks, 350
 * 
 * Output the results in decreasing order of dates and increasing order of
 * actions given
 * 
 */

// Inspired from
public class TimeSeriesDataAggregation {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String range = sc.nextLine();
		sc.nextLine(); // To remove empty line

		HashMap<Integer, HashMap<String, Integer>> actionMap = new HashMap<>();
		ArrayList<Integer> keyList = new ArrayList<>();
		String startDate = range.trim().split(",")[0];
		String endDate = range.trim().split(",")[1];
		String line = "";

		// Take input until empty line is encounters
		while (sc.hasNextLine()) {
			line = sc.nextLine().trim();
			if (!line.equals("")) {
				String[] lineData = line.trim().split(",");

				// To filter the results with given data range
				if (getDateDistance(endDate, lineData[0]) <= 0 || getDateDistance(lineData[0], startDate) <= 0)
					continue;
				int actionMapKey = getDateDistance(lineData[0], startDate);
				String action = lineData[1].trim();
				int actionCount = Integer.parseInt(lineData[2].trim());

				// year-mnth key already exists
				if (actionMap.containsKey(actionMapKey)) {
					// Action key already exists
					if (actionMap.get(actionMapKey).containsKey(action)) {
						actionMap.get(actionMapKey).put(action, actionMap.get(actionMapKey).get(action) + actionCount);
					} else {
						HashMap<String, Integer> map = new HashMap<>();
						map.put(action, actionCount);
						actionMap.get(actionMapKey).put(action, actionCount);
					}
				} else {
					HashMap<String, Integer> map = new HashMap<>();
					map.put(action, actionCount);
					actionMap.put(actionMapKey, map);
				}
				// Add all keys to a list and sort it
				keyList.add(actionMapKey);
			} else
				break;
		}
		Collections.sort(keyList, Collections.reverseOrder());

		ArrayList<String> res = new ArrayList<>();

		// For each key in the sorted list, append all actions and push it to a list
		for (int key : keyList) {
			HashMap<String, Integer> statMap = actionMap.get(key);
			String[] actionList = statMap.keySet().toArray(new String[statMap.size()]);
			Arrays.sort(actionList);

			String statRes = getDateFromNum(key, startDate);
			for (int i = 0; i < actionList.length; i++)
				statRes += ", " + actionList[i] + ", " + actionMap.get(key).get(actionList[i]);
			if (!res.contains(statRes))
				res.add(statRes);

		}

		// Make a single string from the list
		String result = "";
		for (String temp : res)
			result += temp + "\n";
		System.out.println(result);
	}

	// Returns an encrypted number(distance of the current date from the start date
	// in terms of number of months) from the input year-date
	private static int getDateDistance(String currDate, String startDate) {
		String[] arr = currDate.trim().split("-");
		int currYear = Integer.parseInt(arr[0]);
		int currMnth = Integer.parseInt(arr[1]);
		arr = startDate.split("-");
		int startYear = Integer.parseInt(arr[0]);
		int startMnth = Integer.parseInt(arr[1]);

		if (startYear == currYear)
			return currMnth - startMnth;
		else
			return (currYear - startYear) * 12 + currMnth - startMnth;
	}

	// Returns the year-mnth from the input encrypted number
	private static String getDateFromNum(int num, String startDate) {
		String[] arr = startDate.split("-");
		int startYear = Integer.parseInt(arr[0]);
		int startMnth = Integer.parseInt(arr[1]);

		int curryear = startYear + (num + startMnth - 1) / 12;
		int currMnth = (startMnth + num) % 12;

		// Handles corner cases like getting 2016-00
		if (currMnth == 0) {
			curryear--;
			currMnth = 12;
		}

		// To maintain leading zeros in the output
		if (currMnth < 10)
			return curryear + "-0" + currMnth;
		else
			return curryear + "-" + currMnth;
	}

}
