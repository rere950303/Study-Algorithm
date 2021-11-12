//
// DFS(카카오프렌즈 컬러링북)
// https://programmers.co.kr/learn/courses/30/lessons/1829
// Created by hyungwook on 2021/11/11.
//

public class Solution {

    int m;
    int n;
    int areaNum = 0;
    int count = 0;
    int dir[][] = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int picture[][];

    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n = n;
        int[] answer = new int[2];
        this.picture = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                this.picture[i][j] = picture[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (this.picture[i][j] != 0) {
                    int color = this.picture[i][j];
                    areaNum++;
                    count = 1;
                    this.picture[i][j] = 0;
                    dfs(color, i ,j);
                    answer[1] = Math.max(count, answer[1]);
                }
            }
        }

        answer[0] = areaNum;

        return answer;
    }

    private void dfs(int color, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int i1 = r + dir[i][0];
            int i2 = c + dir[i][1];
            if (i1 >= 0 && i1 < m && i2 >= 0 && i2 < n && picture[i1][i2] == color) {
                count++;
                picture[i1][i2] = 0;
                dfs(color, i1, i2);
            }
        }
    }
}