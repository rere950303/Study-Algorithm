//
// 규칙찾기(공 이동 시뮬레이션)
// https://programmers.co.kr/learn/courses/30/lessons/87391
// Created by hyungwook on 2022/02/12.
//

public class Solution {

    public long solution(int n, int m, int x, int y, int[][] queries) {
        int x1 = x;
        int x2 = x;
        int y1 = y;
        int y2 = y;
        int length = queries.length - 1;

        for (int i = length; i >= 0; i--) {
            int dir = queries[i][0];
            int dx = queries[i][1];

            if (dir == 0) {
                if (y1 != 0) {
                    y1 += dx;
                }
                y2 = y2 + dx >= m ? m - 1 : y2 + dx;
                if (y1 >= m) {
                    return 0;
                }
            } else if (dir == 1) {
                if (y2 != m - 1) {
                    y2 -= dx;
                }
                y1 = y1 - dx < 0 ? 0 : y1 - dx;
                if (y2 < 0) {
                    return 0;
                }
            } else if (dir == 2) {
                if (x1 != 0) {
                    x1 += dx;
                }
                x2 = x2 + dx >= n ? n - 1 : x2 + dx;
                if (x1 >= n) {
                    return 0;
                }
            } else {
                if (x2 != n - 1) {
                    x2 -= dx;
                }
                x1 = x1 - dx < 0 ? 0 : x1 - dx;
                if (x2 < 0) {
                    return 0;
                }
            }
        }

        return (long) (x2 - x1 + 1) * (long) (y2 - y1 + 1);
    }
}