//
//  Programmers Algorithm 34(징검다리)
//  https://programmers.co.kr/learn/courses/30/lessons/43236
//  Created by hyungwook on 2021/08/04.
//
package com.company;

import java.util.Arrays;

public class Solution {

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0;
        int right = distance;

        Arrays.sort(rocks);

        while (left <= right) {
            int pc = (left + right) / 2;
            int start = 0;
            int removeNum = 0;

            for (int rock : rocks) {
                int length = rock - start;

                if (length < pc) {
                    removeNum++;
                    if (removeNum > n) {
                        break;
                    }
                } else {
                    start = rock;
                }
            }

            if (removeNum > n) {
                right = pc - 1;
            } else {
                answer = Math.max(answer, pc);
                left = pc + 1;
            }
        }

        return answer;
    }
}
