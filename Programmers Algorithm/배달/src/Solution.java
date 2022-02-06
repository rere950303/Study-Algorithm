//
// 다익스트라(배달)
// https://programmers.co.kr/learn/courses/30/lessons/12978?language=java
// Created by hyungwook on 2022/02/06.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<ArrayList<Node>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] ints : road) {
            int a = ints[0];
            int b = ints[1];
            int t = ints[2];

            list.get(a).add(new Node(b, t));
            list.get(b).add(new Node(a, t));
        }

        int[] time = new int[N + 1];

        Arrays.fill(time, Integer.MAX_VALUE);
        time[1] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (poll.t > time[poll.n]) {
                continue;
            }
            if (poll.t <= K) {
                answer++;
            }
            for (Node node : list.get(poll.n)) {
                if (poll.t + node.t < time[node.n]) {
                    time[node.n] = poll.t + node.t;
                    queue.add(new Node(node.n, poll.t + node.t));
                }
            }
        }

        return answer;
    }

    static class Node implements Comparable<Node> {
        int n;
        int t;

        public Node(int n, int t) {
            this.n = n;
            this.t = t;
        }

        @Override
        public int compareTo(Node o) {
            return this.t - o.t;
        }
    }
}