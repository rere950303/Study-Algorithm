//
// Tree 말단 노드까지의 가장 짧은 경로
//
// Created by hyungwook on 2021/10/04.
//

public class Solution {

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        rootNode.lt = new Node(2);
        rootNode.rt = new Node(3);
        rootNode.rt.lt = new Node(9);
        rootNode.lt.lt = new Node(4);
        rootNode.rt.rt = new Node(5);
        rootNode.rt.rt.rt = new Node(5);

        int answer1 = dfs(rootNode.lt, 0);
        int answer2 = dfs(rootNode.rt, 0);

        System.out.println(Math.min(answer1, answer2));
    }

    private static int dfs(Node node, int n) {
        if (node == null) {
            return n;
        } else {
            return Math.max(dfs(node.lt, n + 1), dfs(node.rt, n + 1));
        }
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
