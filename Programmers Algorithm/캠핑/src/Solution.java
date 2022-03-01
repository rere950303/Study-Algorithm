//
// 좌표압축, Prefix Sum(캠핑)
// https://programmers.co.kr/learn/courses/30/lessons/1833?language=java
// Created by hyungwook on 2022/02/27.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {

    public int solution(int n, int[][] data) {
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            xList.add(data[i][0]);
            yList.add(data[i][1]);
        }

        ArrayList<Integer> uniqueXList = new ArrayList<>(new HashSet<>(xList));
        ArrayList<Integer> uniqueYList = new ArrayList<>(new HashSet<>(yList));

        Collections.sort(uniqueXList);
        Collections.sort(uniqueYList);

        int[][] S = new int[n][n];

        for (int i = 0; i < n; i++) {
            int x = Collections.binarySearch(uniqueXList, data[i][0]);
            int y = Collections.binarySearch(uniqueYList, data[i][1]);

            data[i][0] = x;
            data[i][1] = y;
            S[x][y] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                S[i][j] += (i - 1 >= 0 ? S[i - 1][j] : 0) + (j - 1 >= 0 ? S[i][j - 1] : 0) - (i - 1 >= 0 && j - 1 >= 0 ? S[i - 1][j - 1] : 0);
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int x = data[i][0];
            int y = data[i][1];

            for (int j = i + 1; j < n; j++) {
                if (x == data[j][0] || y == data[j][1]) {
                    continue;
                }
                int startX, startY, endX, endY;

                startX = Math.min(x, data[j][0]);
                startY = Math.min(y, data[j][1]);
                endX = Math.max(x, data[j][0]);
                endY = Math.max(y, data[j][1]);

                int cnt = S[endX - 1][endY - 1] - S[endX - 1][startY] - S[startX][endY - 1] + S[startX][startY];

                if (cnt == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}