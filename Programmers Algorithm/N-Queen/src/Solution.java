//
// DFS(N-Queen)
// https://programmers.co.kr/learn/courses/30/lessons/12952?language=java
// Created by hyungwook on 2022/02/18.
//

public class Solution {

    int n;
    boolean[] widthCheck;
    boolean[] diagonalCheck;
    boolean[] antiDiagonalCheck;

    public int solution(int n) {
        widthCheck = new boolean[n];
        diagonalCheck = new boolean[2 * n + 1];
        antiDiagonalCheck = new boolean[2 * n + 1];
        this.n = n;

        int answer = dfs(0);

        return answer;
    }

    private int dfs(int c) {
        int sum = 0;

        if (c == n) {
            return 1;
        } else {
            for (int r = 0; r < n; r++) {
                if (!widthCheck[r] && !diagonalCheck[r + c] && !antiDiagonalCheck[c - r + n - 1]) {
                    widthCheck[r] = true;
                    diagonalCheck[r + c] = true;
                    antiDiagonalCheck[c - r + n - 1] = true;
                    sum += dfs(c + 1);
                    widthCheck[r] = false;
                    diagonalCheck[r + c] = false;
                    antiDiagonalCheck[c - r + n - 1] = false;
                }
            }

            return sum;
        }
    }
}