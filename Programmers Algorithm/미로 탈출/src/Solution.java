//
// 다익스트라(미로 탈출)
// https://programmers.co.kr/learn/courses/30/lessons/81304
// Created by hyungwook on 2022/02/26.
//

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int[][] matrix = new int[n + 1][n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < traps.length; i++) {
            map.put(traps[i], i);
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= n; i++) {
            matrix[i][i] = 0;
        }

        for (int[] road : roads) {
            int r = road[0];
            int c = road[1];
            matrix[r][c] = Math.min(matrix[r][c], road[2]);
        }

        boolean[][] check = new boolean[n + 1][1 << 10];

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int state = poll.state;

            if (poll.n == end) {
                return poll.c;
            }

            if (check[poll.n][state]) {
                continue;
            }
            check[poll.n][state] = true;

            for (int i = 1; i <= n; i++) {
                if (i == poll.n) {
                    continue;
                }
                int nextTrapped = 0;
                int currTrapped = 0;

                if (map.containsKey(i)) {
                    nextTrapped = state & (1 << map.get(i));
                }
                if (map.containsKey(poll.n)) {
                    currTrapped = state & (1 << map.get(poll.n));
                }
                int r;
                int c;
                int dst;

                if ((nextTrapped == 0 && currTrapped != 0) || (nextTrapped != 0 && currTrapped == 0)) {
                    r = i;
                    c = poll.n;
                    dst = r;
                } else {
                    r = poll.n;
                    c = i;
                    dst = c;
                }

                if (matrix[r][c] != Integer.MAX_VALUE) {
                    int i3 = poll.state;
                    if (map.containsKey(dst)) {
                        i3 = poll.state ^ (1 << map.get(dst));
                    }
                    queue.add(new Node(dst, matrix[r][c] + poll.c, i3));
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static class Node implements Comparable<Node> {
        int n;
        int c;
        int state;

        public Node(int n, int c, int state) {
            this.n = n;
            this.c = c;
            this.state = state;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }
}