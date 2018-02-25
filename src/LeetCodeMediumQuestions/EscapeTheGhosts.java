package LeetCodeMediumQuestions;

public class EscapeTheGhosts {
	public boolean escapeGhosts(int[][] ghosts, int[] target) {
		int pacmanSteps = getNumSteps(new int[] { 0, 0 }, target);
		for (int i = 0; i < ghosts.length; i++) {
			if (getNumSteps(ghosts[i], target) <= pacmanSteps)
				return false;
		}
		return true;
	}

	private int getNumSteps(int[] source, int[] dest) {
		return Math.abs(source[0] - dest[0]) + Math.abs(source[1] - dest[1]);
	}
}
