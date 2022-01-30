//
// 규칙 찾기(파괴되지 않은 건물)
// https://programmers.co.kr/learn/courses/30/lessons/92344?language=java
// Created by hyungwook on 2022/01/23.
//

public class Solution {

    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] damage = new int[n + 1][m + 1];
        int answer = 0;

        for (int[] ints : skill) {
            int k = ints[0];
            int r1 = ints[1];
            int c1 = ints[2];
            int r2 = ints[3];
            int c2 = ints[4];
            int d = ints[5];

            if (k == 1) {
                d *= -1;
            }

            for (int i = r1; i <= r2; i++) {
                damage[i][c1] += d;
                damage[i][c2 + 1] += -1 * d;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                damage[i][j] += damage[i][j - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += damage[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
