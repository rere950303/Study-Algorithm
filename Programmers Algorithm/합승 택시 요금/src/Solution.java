//
// 다익스트라(합승 택시 요금)
// https://programmers.co.kr/learn/courses/30/lessons/72413?language=java
// Created by hyungwook on 2021/11/03.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    ArrayList<ArrayList<Node>> list;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            list.get(fare[0]).add(new Node(fare[1], fare[2]));
            list.get(fare[1]).add(new Node(fare[0], fare[2]));
        }

        int[] startOfs = dijkstra(s, n);
        int[] startOfa = dijkstra(a, n);
        int[] startOfb = dijkstra(b, n);

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, startOfa[i] + startOfs[i] + startOfb[i]);
        }

        return answer;
    }

    private int[] dijkstra(int a, int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(a, 0));
        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[a] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.c > arr[poll.n]) {
                continue;
            }

            for (Node node : list.get(poll.n)) {
                if (node.c + poll.c < arr[node.n]) {
                    arr[node.n] = node.c + poll.c;
                    queue.add(new Node(node.n, node.c + poll.c));
                }
            }
        }

        return arr;
    }

    static class Node implements Comparable<Node> {
        int n;
        int c;

        public Node(int n, int c) {
            this.n = n;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }
}