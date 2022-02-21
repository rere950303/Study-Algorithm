//
// DFS(쿼드압축 후 개수 세기)
// https://programmers.co.kr/learn/courses/30/lessons/68936?language=java
// Created by hyungwook on 2022/02/09.
//

public class Solution {

    int numZero = 0;
    int numOne = 0;
    int[][] arr;

    public int[] solution(int[][] arr) {
        this.arr = arr;
        dfs(new int[]{0, 0}, arr.length);

        return new int[]{numZero, numOne};
    }

    private void dfs(int[] start, int length) {
        int flag = check(start, length);

        if (flag == 0) {
            numZero++;
            return;
        }
        if (flag == 1) {
            numOne++;
            return;
        }

        length = length / 2;

        dfs(start, length);
        dfs(new int[]{start[0], start[1] + length}, length);
        dfs(new int[]{start[0] + length, start[1]}, length);
        dfs(new int[]{start[0] + length, start[1] + length}, length);
    }

    private int check(int[] start, int length) {
        int r = start[0];
        int c = start[1];
        int flag = arr[r][c];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (flag != arr[r + i][c + j]) {
                    return -1;
                }
            }
        }

        return flag;
    }
}