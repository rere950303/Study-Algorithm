//
// Linked List, Math, Recursion(Add Two Numbers)
// https://leetcode.com/problems/add-two-numbers/
// Created by hyungwook on 2022/02/23.
//

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        int carry = 0;
        ListNode node = dummy;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;

            if (sum >= 10) {
                carry = 1;
                node.next = new ListNode(sum - 10);
            } else {
                carry = 0;
                node.next = new ListNode(sum);
            }

            node = node.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry == 1) {
            node.next = new ListNode(1);
        }

        return dummy.next;
    }

    static class ListNode {
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