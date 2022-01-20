//
// 다익스트라 알고리즘2
//
// Created by hyungwook on 2021/10/13.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            list.get(sc.nextInt()).add(new Node(sc.nextInt(), sc.nextInt()));
        }

        int[] answer = new int[n + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.c > answer[poll.node]) {
                continue;
            }
            for (Node node : list.get(poll.node)) {
                if (node.c + poll.c < answer[node.node]) {
                    answer[node.node] = node.c + poll.c;
                    queue.add(new Node(node.node, node.c + poll.c));
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (answer[i] != Integer.MAX_VALUE) {
                System.out.println(answer[i]);
            } else {
                System.out.println("impossible");
            }
        }
    }

    static class Node implements Comparable<Node> {
        int node;
        int c;

        public Node(int node, int c) {
            this.node = node;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }
}