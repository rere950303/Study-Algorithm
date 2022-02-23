//
// DP(사칙연산)
// https://programmers.co.kr/learn/courses/30/lessons/1843?language=java
// Created by hyungwook on 2022/02/22.
//

import java.util.Arrays;

public class Solution {

    public int solution(String arr[]) {
        int length = arr.length;
        int[][] max = new int[length][length];
        int[][] min = new int[length][length];

        for (int i = 0; i < length; i += 2) {
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < length; i += 2) {
            max[i][i] = Integer.valueOf(arr[i]);
            min[i][i] = Integer.valueOf(arr[i]);
        }

        for (int len = 2; len < length; len += 2) {
            for (int start = 0; start < length - len; start += 2) {
                int last = start + len;

                for (int k = start; k < last; k += 2) {
                    if (arr[k + 1].equals("+")) {
                        max[start][last] = Math.max(max[start][last], max[start][k] + max[k + 2][last]);
                        min[start][last] = Math.min(min[start][last], min[start][k] + min[k + 2][last]);
                    } else {
                        max[start][last] = Math.max(max[start][last], max[start][k] - min[k + 2][last]);
                        min[start][last] = Math.min(min[start][last], min[start][k] - max[k + 2][last]);
                    }
                }
            }
        }

        return max[0][length - 1];
    }
}