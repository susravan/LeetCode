package LeetCodeMediumQuestions;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Sravan
 * Created on Jan 20, 2018
 */

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * 
 * Corner Cases: Did you consider the case where path = "/../"? In this case,
 * you should return "/". Another corner case is the path might contain multiple
 * slashes '/' together, such as "/home//foo/". In this case, you should ignore
 * redundant slashes and return "/home/foo".
 *
 */

public class SimplifyPath {
	public String simplifyPath(String path) {
		String[] strs = path.split("/");
		StringBuilder sb = new StringBuilder();
		List<String> list = new LinkedList<>();

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].equals("..")) {
				// Remove from top
				if (!list.isEmpty())
					list.remove(list.size() - 1);
			} else if (strs[i].equals(".") || strs[i].equals(""))
				continue;
			else {
				list.add(strs[i]);
			}
		}
		if (list.isEmpty())
			return "/";

		while (!list.isEmpty()) {
			sb.append("/").append(list.remove(0)); // Remove from start
		}
		return sb.toString();
	}
}
