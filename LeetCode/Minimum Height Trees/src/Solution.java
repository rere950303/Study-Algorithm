//
// BFS, Graph, Topological Sort(Minimum Height Trees)
// https://leetcode.com/problems/minimum-height-trees/
// Created by hyungwook on 2022/07/01.
//

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        List<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        int[] degrees = new int[n];

        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;

            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                queue.add(i);
            }
        }

        while (n > 2) {
            int size = queue.size();

            n -= size;
            for (int i = 0; i < size; i++) {
                List<Integer> neighbors = adjacencyList.get(queue.poll());

                for (int neighbor : neighbors) {
                    degrees[neighbor]--;

                    if (degrees[neighbor] == 1) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }
}