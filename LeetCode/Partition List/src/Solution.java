// https://leetcode.com/problems/partition-list/description/

class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode less = new ListNode(0);
		ListNode lessCurr = less;
		ListNode greater = new ListNode(0);
		ListNode greaterCurr = greater;

		while (head != null) {
			if (head.val < x) {
				lessCurr.next = head;
				lessCurr = head;
			} else {
				greaterCurr.next = head;
				greaterCurr = head;
			}
			head = head.next;
		}

		greaterCurr.next = null;
		lessCurr.next = greater.next;

		return less.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}