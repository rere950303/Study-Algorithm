//
// Linked List, Two Pointers(Remove Nth Node From End of List)
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Created by hyungwook on 2022/02/25.
//

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int totalNum = 0;

        while (node != null) {
            totalNum++;
            node = node.next;
        }

        if (totalNum == n) {
            return head.next;
        }

        ListNode prev = head;
        ListNode curr = head;

        for (int i = 0; i < totalNum - n; i++) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;

        return head;
    }

    public static class ListNode {
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