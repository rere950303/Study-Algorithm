//
// Matrix, Simulation(Game of Life)
// https://leetcode.com/problems/game-of-life/
// Created by hyungwook on 2022/03/10.
//

public class Solution {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveCount = 0;

                for (int k = 0; k < 8; k++) {
                    int rn = i + dir[k][0];
                    int cn = j + dir[k][1];

                    if (rn >= 0 && rn < m && cn >= 0 && cn < n && (board[rn][cn] == 1 || board[rn][cn] == -1)) {
                        liveCount++;
                    }
                }
                if (board[i][j] == 1 && !(liveCount == 2 || liveCount == 3)) {
                    board[i][j] = -1;
                } else if (board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = -2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == -2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}