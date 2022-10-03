//
// Dijkstra, DP, Graph(Number of Ways to Arrive at Destination)
// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
// Created by hyungwook on 2022/07/01.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public int countPaths(int n, int[][] roads) {
        List<ArrayList<long[]>> adjacencyList = new ArrayList<>();
        int modulo = (int) (Math.pow(10, 9) + 7);

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adjacencyList.get(road[0]).add(new long[]{road[1], road[2]});
            adjacencyList.get(road[1]).add(new long[]{road[0], road[2]});
        }
        long[] costs = new long[n];
        int[] ways = new int[n];
        ways[0] = 1;
        costs[0] = 0;
        Arrays.fill(costs, Long.MAX_VALUE);
        PriorityQueue<long[]> queue = new PriorityQueue<>((i1, i2) -> Long.compare(i1[1], i2[1]));
        queue.add(new long[]{0, 0});

        while (!queue.isEmpty()) {
            long[] frontier = queue.poll();

            if (costs[(int) frontier[0]] < frontier[1]) {
                continue;
            }

            for (long[] neighbors : adjacencyList.get((int) frontier[0])) {
                int neighbor = (int) neighbors[0];
                long cost = neighbors[1];
                long newCost = frontier[1] + cost;

                if (costs[neighbor] > newCost) {
                    costs[neighbor] = newCost;
                    queue.add(new long[]{neighbor, newCost});
                    ways[neighbor] = ways[(int) frontier[0]];
                } else if (costs[neighbor] == newCost) {
                    ways[neighbor] = (ways[(int) frontier[0]] + ways[neighbor]) % modulo;
                }
            }
        }

        return ways[n - 1];
    }
}