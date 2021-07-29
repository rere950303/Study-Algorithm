//
//  Programmers Algorithm 30(네트워크)
//  https://programmers.co.kr/learn/courses/30/lessons/43162
//  Created by hyungwook on 2021/07/29.
//
package com.company;

import java.util.Arrays;

public class Solution {

    public int solution(int n, int[][] computers) {
        int[] connect = new int[n];

        for (int i = 0; i < n; i++) {
            connect[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    connecting(i, j, n, connect);
                }
            }
        }

        return (int) Arrays.stream(connect).distinct().count();
    }

    private void connecting(int i, int j, int n, int[] connect) {
        int pc = connect[j];
        for (int k = 0; k < n; k++) {
            if (connect[k] == pc) {
                connect[k] = connect[i];
            }
        }
    }
}
