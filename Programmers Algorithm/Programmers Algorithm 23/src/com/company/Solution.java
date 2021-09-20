//
//  Programmers Algorithm 23(섬 연결하기)
//  https://programmers.co.kr/learn/courses/30/lessons/42861?language=java
//  Created by hyungwook on 2021/07/20.
//

package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int n, int[][] costs) {
        int count = 0;
        int answer = 0;
        int[] islandLinking = new int[n];
        int pc = 0;

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < n; i++) {
            islandLinking[i] = i;
        }

        while (count < n - 1) {
            if (islandLinking[costs[pc][0]] != islandLinking[costs[pc][1]]) {
                linking(islandLinking, Math.min(islandLinking[costs[pc][0]], islandLinking[costs[pc][1]]),
                        Math.max(islandLinking[costs[pc][0]], islandLinking[costs[pc][1]]));
                answer += costs[pc][2];
                pc++;
                count++;
                continue;
            }
            pc++;
        }

        return answer;
    }

    void linking(int[] islandLinking, int a, int b) {
        int length = islandLinking.length;


        for (int i = 0; i < length; i++) {
            if (islandLinking[i] == b) {
                islandLinking[i] = a;
            }
        }
    }
}
