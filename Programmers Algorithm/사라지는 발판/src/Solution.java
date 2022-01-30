//
// DFS(사라지는 발판)
// https://programmers.co.kr/learn/courses/30/lessons/92345
// Created by hyungwook on 2022/01/24.
//

public class Solution1 {
    int n;
    int m;
    int[][] board;
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        this.n = board.length;
        this.m = board[0].length;
        int ar = aloc[0];
        int ac = aloc[1];
        int br = bloc[0];
        int bc = bloc[1];

        int answer = dfs(ar, ac, br, bc, 0, 1);

        return Math.abs(answer);
    }

    private int dfs(int ar, int ac, int br, int bc, int l, int turn) {
        int win = Integer.MAX_VALUE;
        int lose = 0;

        if ((turn == 1 && board[ar][ac] == 0) || (turn == -1 && board[br][bc] == 0)) {
            return l * turn * -1;
        }

        for (int i = 0; i < 4; i++) {
            if (turn > 0) {
                int ax = ar + dir[i][0];
                int ay = ac + dir[i][1];

                if (ax >= 0 && ax < n && ay >= 0 && ay < m && board[ax][ay] == 1) {
                    board[ar][ac] = 0;
                    int A = dfs(ax, ay, br, bc, l + 1, turn * -1);

                    if (A < 0) {
                        lose = Math.min(A, lose);
                    } else {
                        win = Math.min(A, win);
                    }
                    board[ar][ac] = 1;
                }
            } else {
                int bx = br + dir[i][0];
                int by = bc + dir[i][1];

                if (bx >= 0 && bx < n && by >= 0 && by < m && board[bx][by] == 1) {
                    board[br][bc] = 0;
                    int B = dfs(ar, ac, bx, by, l + 1, turn * -1);

                    if (B > 0) {
                        lose = Math.max(B, lose);
                    } else {
                        win = Math.min(Math.abs(B), win);
                    }
                    board[br][bc] = 1;
                }
            }
        }

        if (win == Integer.MAX_VALUE && lose == 0) {
            return l * turn * -1;
        }
        if (win != Integer.MAX_VALUE) {
            return win * turn;
        }
        else {
            return Math.abs(lose) * -1 * turn;
        }
    }
}