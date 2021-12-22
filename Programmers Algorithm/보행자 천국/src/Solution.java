//
// 동적계획법(보행자 천국)
// https://programmers.co.kr/learn/courses/30/lessons/1832
// Created by hyungwook on 2021/11/29.
//

public class Solution {

    public int solution(int m, int n, int[][] cityMap) {
        int MOD = 20170805;
        int[][][] dp = new int[m][n][2];

        for (int i = 0; i < m; i++) {
            if (cityMap[i][0] == 1) {
                break;
            }
            dp[i][0][1] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (cityMap[0][i] == 1) {
                break;
            }
            dp[0][i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) {
                    continue;
                }
                dp[i][j][0] = (cityMap[i][j - 1] == 2 ? dp[i][j - 1][0] : dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                dp[i][j][1] = (cityMap[i - 1][j] == 2 ? dp[i - 1][j][1] : dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
            }
        }

        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
    }
}