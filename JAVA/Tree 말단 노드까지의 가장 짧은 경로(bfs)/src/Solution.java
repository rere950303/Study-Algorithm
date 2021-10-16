//
// Tree 말단 노드까지의 가장 짧은 경로(bfs)
//
// Created by hyungwook on 2021/10/05.
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.lt = new Node(2);
        rootNode.lt.lt = new Node(4);
        rootNode.lt.rt = new Node(5);
        rootNode.rt = new Node(3);
        Queue<Node> queue = new LinkedList<>();

        int answer = bfs(rootNode, queue);

        System.out.println(answer);
    }

    private static int bfs(Node rootNode, Queue<Node> queue) {
        int answer = 0;
        queue.add(rootNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll.lt == null && poll.rt == null) {
                    return answer;
                }
                if (poll.lt != null) {
                    queue.add(poll.lt);
                }
                if (poll.rt != null) {
                    queue.add(poll.rt);
                }
            }
            answer++;
        }

        return answer;
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