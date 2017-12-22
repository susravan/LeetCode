package LeetCodeMediumQuestions;

public class RemoveNthNode {
	public ListNode removeNthNode(ListNode head, int N) {
		int index = 0;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		while(index < N) {
			fast = fast.next;
			index++;
		}
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}
