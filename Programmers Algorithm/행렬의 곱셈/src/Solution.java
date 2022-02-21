//
// for문(행렬의 곱셈)
// https://programmers.co.kr/learn/courses/30/lessons/12949?language=java
// Created by hyungwook on 2022/02/18.
//

public class Solution {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r = arr1.length;
        int c = arr2[0].length;
        int[][] answer = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int tmp = 0;

                for (int k = 0; k < arr1[0].length; k++) {
                    tmp += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = tmp;
            }
        }

        return answer;
    }
}
