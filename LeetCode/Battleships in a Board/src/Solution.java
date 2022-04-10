//
// DFS, Matrix(Battleships in a Board)
// https://leetcode.com/problems/battleships-in-a-board/
// Created by hyungwook on 2022/04/01.
//

public class Solution {

    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m;
    int n;

    public int countBattleships(char[][] board) {
        m = board.length;
        n = board[0].length;
        int answer = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'X') {
                    answer++;
                    board[r][c] = '.';
                    dfs(board, r, c);
                }
            }
        }

        return answer;
    }

    private void dfs(char[][] board, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int rn = r + dir[i][0];
            int cn = c + dir[i][1];

            if (rn >= 0 && rn < m && cn >= 0 && cn < n && board[rn][cn] == 'X') {
                board[rn][cn] = '.';
                dfs(board, rn ,cn);
            }
        }
    }
}