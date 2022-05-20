//
// Dijkstra, Graph, Heap(Network Delay Time)
// https://leetcode.com/problems/network-delay-time/
// Created by hyungwook on 2022/05/15.
//

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<ArrayList<int[]>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] time : times) {
            list.get(time[0]).add(new int[]{time[1], time[2]});
        }
        boolean[] isVisit = new boolean[n + 1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1], i2[1]));
        queue.add(new int[]{k, 0});
        int answer = -1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (isVisit[poll[0]]) {
                continue;
            }
            isVisit[poll[0]] = true;
            answer = poll[1];

            List<int[]> ints = list.get(poll[0]);

            for (int[] anInt : ints) {
                if (!isVisit[anInt[0]]) {
                    queue.add(new int[]{anInt[0], poll[1] + anInt[1]});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!isVisit[i]) {
                return -1;
            }
        }

        return answer;
    }
}
