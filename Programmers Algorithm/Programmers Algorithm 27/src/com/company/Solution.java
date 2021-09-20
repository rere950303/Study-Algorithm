//
//  Programmers Algorithm 27(등굣길)
//  https://programmers.co.kr/learn/courses/30/lessons/42898
//  Created by hyungwook on 2021/07/25.
//

package com.company;

public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] nodes = new int[n + 1][m + 1]; // 문제 조건과 동일하게 풀기 위해 행과 열을 교체

        //첫번째 행과 열을 1로 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                nodes[i][j] = 1;
            }
        }

        //웅덩이가 있는 좌표를 0으로 설정하고 만약 첫번째 행 또는 열에 웅덩이가 있는경우 그 뒤 노드를 0으로 설정
        for (int[] puddle : puddles) {
            nodes[puddle[1]][puddle[0]] = 0;
            if (puddle[0] == 1) {
                for (int i = puddle[1] + 1; i <= n; i++) {
                    nodes[i][1] = 0;
                }
            }
            if (puddle[1] == 1) {
                for (int i = puddle[0] + 1; i <= m; i++) {
                    nodes[1][i] = 0;
                }
            }
        }

        //2번째 열 처리
        for (int i = 2; i <= n; i++) {
            if (nodes[i][2] == 0) {
                continue;
            }
            if (nodes[i - 1][2] == 0 || nodes[i][1] == 0 || nodes[i - 1][1] == 0) {
                nodes[i][2] = Math.max(nodes[i - 1][2], nodes[i][1]) % 1000000007;
            } else {
                nodes[i][2] = (nodes[i - 1][2] + nodes[i][1]) % 1000000007;
            }
        }

        //2번째 행 처리
        for (int i = 2; i <= m; i++) {
            if (nodes[2][i] == 0) {
                continue;
            }
            if (nodes[2][i - 1] == 0 || nodes[1][i] == 0 || nodes[1][i - 1] == 0) {
                nodes[2][i] = Math.max(nodes[2][i - 1], nodes[1][i]) % 1000000007;
            } else {
                nodes[2][i] = (nodes[2][i - 1] + nodes[1][i]) % 1000000007;
            }
        }

        //그 외 나머지 노드는 왼쪽과 위쪽 노드의 합과 동일
        for (int i = 3; i <= m; i++) {
            for (int j = 3; j <= n; j++) {
                if (nodes[j][i] == 0) {
                    continue; // 위쪽으로 갈수 없는 조건을 고려
                }
                nodes[j][i] = (nodes[j - 1][i] + nodes[j][i - 1]) % 1000000007;
            }
        }

        return nodes[n][m];
    }
}
