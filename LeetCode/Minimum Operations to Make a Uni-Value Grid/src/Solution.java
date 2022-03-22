//
// Sorting, Math, Array(Minimum Operations to Make a Uni-Value Grid)
// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/
// Created by hyungwook on 2022/03/22.
//

import java.util.Arrays;

public class Solution {

    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        int idx = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[idx++] = grid[i][j];
            }
        }

        Arrays.sort(arr);
        int median = arr[(arr.length - 1) / 2];
        int answer = 0;

        for (int v : arr) {
            if (v == median) {
                continue;
            }
            if ((v - median) % x != 0) {
                return -1;
            } else {
                answer += Math.abs(v - median) / x;
            }
        }

        return answer;
    }
}