package LeetCodeMediumQuestions;

public class RemoveDupSortedArray {
	public int removeDup(int[] arr) {
		if(arr == null || arr.length == 0)
			return 0;
		int slow = 0, fast = 1;
		while(fast < arr.length) {
			if(arr[slow] == arr[fast]) {
				fast++;
			}
			else {
				if(fast - slow == 1) {
					slow++;
					fast++;
				}
				else {
					arr[++slow] = arr[fast++];
				}
			}
		}
		return slow+1;
	}
}
