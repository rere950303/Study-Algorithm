//
// Hash Table, Linked List(Copy List with Random Pointer)
// https://leetcode.com/problems/copy-list-with-random-pointer/
// Created by hyungwook on 2022/03/12.
//

import java.util.HashMap;
import java.util.Objects;

public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node prev = dummy;
        Node curr = head;

        while (curr != null) {
            Node next = new Node(curr.val);
            prev.next = next;
            map.put(curr, next);
            prev = next;
            curr = curr.next;
        }

        Node tmp = dummy.next;
        curr = head;
        while (tmp != null) {
            tmp.random = map.get(curr.random);
            tmp = tmp.next;
            curr = curr.next;
        }

        return dummy.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val && Objects.equals(next, node.next) && Objects.equals(random, node.random);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next, random);
        }
    }
}