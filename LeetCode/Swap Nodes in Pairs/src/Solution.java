//
// Linked List, Recursion(Swap Nodes in Pairs)
// https://leetcode.com/problems/swap-nodes-in-pairs/
// Created by hyungwook on 2022/02/24.
//

public class Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode node = head;

        while (node != null) {
            ListNode next = node.next;

            if (next != null) {
                int tmp = next.val;
                next.val = node.val;
                node.val = tmp;
                node = next.next;
            } else {
                node = null;
            }
        }

        return head;
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