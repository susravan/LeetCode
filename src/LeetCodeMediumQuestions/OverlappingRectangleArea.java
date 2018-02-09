package LeetCodeMediumQuestions;

/**
 * @author Sravan
 * Created on Feb 8, 2018
 */

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure.
 * 
 * Rectangle Area Assume that the total area is never beyond the maximum
 * possible value of int.
 */

// Inspired from
public class OverlappingRectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area = ((C - A) * (D - B)) + ((G - E) * (H - F));
		// To get overlapping rectangle's coordinates, think of it as a line moving from
		// left to right where it should be stopped to get the overlapped region.
		// Similarly a line moving from bottom to top would get 2 Y-coordinates
		int left = Math.max(A, E);
		int bottom = Math.max(B, F);
		int right = Math.min(C, G);
		int top = Math.min(D, H);
		int overlapArea = (right - left) * (top - bottom);

		if (bottom < top && left < right)
			return area - overlapArea;

		return area;
	}
}
