//
// 동적계획법(GPS)
// https://programmers.co.kr/learn/courses/30/lessons/1837
// Created by hyungwook on 2021/11/24.
//

import java.util.ArrayList;

public class Solution {

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            list.get(i).add(i);
        }
        for (int[] ints : edge_list) {
            list.get(ints[0]).add(ints[1]);
            list.get(ints[1]).add(ints[0]);
        }

        int[][] dp = new int[k][n + 1];
        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][gps_log[0]] = 0;

        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.MAX_VALUE;
                ArrayList<Integer> integers = list.get(j);
                for (Integer integer : integers) {
                    if (dp[i - 1][integer] != -1) {
                        tmp = Math.min(tmp, dp[i - 1][integer]);
                    }
                }
                if (tmp != Integer.MAX_VALUE) {
                    dp[i][j] = tmp;
                    if (j != gps_log[i]) {
                        dp[i][j]++;
                    }
                }
            }
        }

        return dp[k - 1][gps_log[k - 1]];
    }
}