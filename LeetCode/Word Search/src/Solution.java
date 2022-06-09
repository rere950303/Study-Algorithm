//
// DFS, Backtracking, Matrix(Word Search)
// https://leetcode.com/problems/word-search/
// Created by hyungwook on 2022/06/08.
//

public class Solution {

    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m;
    int n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int l) {
        if (board[r][c] != word.charAt(l)) {
            return false;
        }
        if (l == word.length() - 1) {
            return true;
        }
        char tmp = board[r][c];
        board[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int rn = r + dir[i][0];
            int cn = c + dir[i][1];

            if (rn >= 0 && rn < m && cn >= 0 && cn < n && board[rn][cn] != 0) {
                if (dfs(board, word, rn, cn, l + 1)) {
                    board[r][c] = tmp;
                    return true;
                }
            }
        }

        board[r][c] = tmp;
        return false;
    }
}