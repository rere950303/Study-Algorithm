//
//  Programmers Algorithm 26(정수 삼각형)
//  https://programmers.co.kr/learn/courses/30/lessons/43105
//  Created by hyungwook on 2021/07/24.
//
package com.company;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] triangle) {

        int length = triangle.length;

        for (int i = 1; i < length; i++) {
            triangle[i][0] = triangle[i][0] + triangle[i - 1][0];
            for (int j = 1; j < i; j++) {
                triangle[i][j] = Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]) + triangle[i][j];
            }
            triangle[i][i] = triangle[i][i] + triangle[i - 1][i - 1];
        }

        return Arrays.stream(triangle[length - 1]).max().getAsInt();
    }
}
