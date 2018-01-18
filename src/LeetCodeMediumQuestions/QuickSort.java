package LeetCodeMediumQuestions;

import java.util.Arrays;

/**
 * @author Sravan
 * 
 * Quick sort is implemented and commented step by step in order
 * to make it understand when you run the code with an example
 *
 * 
 */

// Inspired from
public class QuickSort {

	public int[] quickSort(int[] arr) {
		if (arr.length < 2)
			return arr;

		quickSortHelper(arr, 0, arr.length - 1);
		return arr;
	}

	private void quickSortHelper(int[] arr, int lo, int high) {
		// Approach: Make pivotIndex mid of the array, put two pointers from wither
		// highs
		// and compare both of them with pivotIndex element, when an anamoly observed,
		// swap both
		System.out.println(
				"Executing partionByMid on " + Arrays.toString(arr) + " from index " + lo + " to index " + high);
		int pivotIndex = lo + (high - lo) / 2;
		int i = lo, j = high;
		System.out.println("Current pivot element = " + arr[pivotIndex]);
		// Equality is required to make recursion call indices calculation easier
		while (i <= j) {
			// Get first left side element greater than pivot element
			while (arr[i] < arr[pivotIndex])
				i++;
			System.out.println("Found " + arr[i] + " to the left of pivot, ready to swap");
			// Get first right side element lesser than pivot element
			while (arr[j] > arr[pivotIndex])
				j--;
			System.out.println("Found " + arr[j] + " to the right of pivot, ready to swap");

			// Swap ith and jth elements
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
				System.out.println("Swapping completed, current indices - " + i + ", " + j);
			} else
				System.out.println("Did not swap as j < i");
			System.out.println("-------------------------------------------");
		}
		System.out.println("Array pivot completed on " + arr[pivotIndex]);
		System.out.println("Current array = " + Arrays.toString(arr));

		// Recurse the same process to the left and right subparts of the array
		if (lo < j)
			quickSortHelper(arr, lo, j);
		if (high > i)
			quickSortHelper(arr, i, high);
	}

	private int partitionByMid(int[] arr, int lo, int high) {
		// Approach: Make pivotIndex mid of the array, put two pointers from wither
		// highs
		// and compare both of them with pivotIndex element, when an anamoly observed,
		// swap both
		System.out.println(
				"Executing partionByMid on " + Arrays.toString(arr) + " from index " + lo + " to index " + high);
		int pivotIndex = lo + (high - lo) / 2;
		int i = lo, j = high;
		System.out.println("Current pivot element = " + arr[pivotIndex]);
		// Equality is required to make recursion call indices calculation easier
		while (i <= j) {
			// Get first left side element greater than pivot element
			while (arr[i] < arr[pivotIndex])
				i++;
			System.out.println("Found " + arr[i] + " to the left of pivot, ready to swap");
			// Get first right side element lesser than pivot element
			while (arr[j] > arr[pivotIndex])
				j--;
			System.out.println("Found " + arr[j] + " to the right of pivot, ready to swap");

			// Swap ith and jth elements
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
				System.out.println("Swapping completed, current indices - " + i + ", " + j);
			} else
				System.out.println("Did not swap as j < i");
			System.out.println("-------------------------------------------");
		}
		return pivotIndex;
	}

	private int partitionByFirst(int[] arr, int lo, int high) {
		// Approach: Always make the first element as pivot, parse the array, all
		// elements less than pivot put them to the left of pivot
		int pivotIndex = lo;
		System.out.println("Current pivot element = " + arr[pivotIndex]);
		for (int i = lo + 1; i <= high; i++) {
			if (arr[i] > arr[pivotIndex]) {
				// Swap
				int temp = arr[i];
				arr[i] = arr[pivotIndex];
				arr[pivotIndex] = temp;
				pivotIndex = i;
			}

		}
		return pivotIndex;
	}

}
