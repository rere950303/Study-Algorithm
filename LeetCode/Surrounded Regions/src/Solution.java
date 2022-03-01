//
// DFS, Matrix(Surrounded Regions)
// https://leetcode.com/problems/surrounded-regions/
// Created by hyungwook on 2022/03/01.
//

public class Solution {

    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m;
    int n;
    boolean[][] check;
    char[][] board;

    public void solve(char[][] board) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        check = new boolean[m][n];

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O' && !check[0][i]) {
                check[0][i] = true;
                dfs(0, i);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O' && !check[i][n - 1]) {
                check[i][n - 1] = true;
                dfs(i, n - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[m - 1][i] == 'O' && !check[m - 1][i]) {
                check[m - 1][i] = true;
                dfs(m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !check[i][0]) {
                check[i][0] = true;
                dfs(i, 0);
            }
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !check[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int rn = r + dir[i][0];
            int cn = c + dir[i][1];

            if (rn >= 0 && rn < m && cn >= 0 && cn < n && board[rn][cn] == 'O' && !check[rn][cn]) {
                check[rn][cn] = true;
                dfs(rn, cn);
            }
        }
    }
}