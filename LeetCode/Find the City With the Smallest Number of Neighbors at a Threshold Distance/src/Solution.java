//
// Floyd Warshall, DP, Graph(Find the City With the Smallest Number of Neighbors at a Threshold Distance)
// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
// Created by hyungwook on 2022/04/04.
//

class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];

        initMatrix(n, edges, matrix);
        for (int stopover = 0; stopover < n; stopover++) {
            for (int from = 0; from < n; from++) {
                for (int to = 0; to < n; to++) {
                    matrix[from][to] = Math.min(matrix[from][to], matrix[from][stopover] + matrix[stopover][to]);
                }
            }
        }
        int answer = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= min) {
                min = count;
                answer = i;
            }
        }

        return answer;
    }

    private void initMatrix(int n, int[][] edges, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 20000;
                }
            }
        }

        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = matrix[edge[1]][edge[0]] = edge[2];
        }
    }
}