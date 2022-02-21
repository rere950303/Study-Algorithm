//
// DP(가장 큰 정사각형 찾기)
// https://programmers.co.kr/learn/courses/30/lessons/12905
// Created by hyungwook on 2022/02/10.
//

public class Solution {

    public int solution(int[][] board) {
        int r = board.length;
        int c = board[0].length;
        int[][] dp = new int[r + 1][c + 1];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dp[i + 1][j + 1] = board[i][j];
            }
        }

        int answer = 0;

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (dp[i][j] != 0) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer * answer;
    }
}