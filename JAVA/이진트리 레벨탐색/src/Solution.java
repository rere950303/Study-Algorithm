//
// 이진트리 레벨탐색
//
// Created by hyungwook on 2021/10/04.
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        Queue<Node> queue = new LinkedList<>();
        Node rootNode = new Node(1);
        rootNode.lt = new Node(2);
        rootNode.lt.lt = new Node(4);
        rootNode.lt.rt = new Node(5);
        rootNode.rt = new Node(3);
        rootNode.rt.lt = new Node(6);
        rootNode.rt.rt = new Node(7);

        bfs(rootNode, queue);
    }

    private static void bfs(Node node, Queue<Node> queue) {
        queue.add(node);

        while (!queue.isEmpty()) {
            print(queue);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll.lt != null) {
                    queue.add(poll.lt);
                }
                if (poll.rt != null) {
                    queue.add(poll.rt);
                }
            }
        }
    }

    private static void print(Queue<Node> queue) {
        queue.stream().forEach(q -> System.out.print(q.data + " "));
    }

    static class Node {
        Node lt;
        Node rt;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
