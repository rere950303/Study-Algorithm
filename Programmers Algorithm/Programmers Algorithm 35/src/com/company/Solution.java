//
//  Programmers Algorithm 35(가장 먼 노드)
//  https://programmers.co.kr/learn/courses/30/lessons/49189
//  Created by hyungwook on 2021/08/05.
//

package com.company;

import java.util.LinkedList;

public class Solution {

    public int solution(int n, int[][] edge) {
        boolean[][] connectNode = new boolean[n + 1][n + 1];
        boolean[] check = new boolean[n + 1];
        LinkedList<Integer> list = new LinkedList<>();
        int answer = 0;

        for (int[] ints : edge) {
            connectNode[ints[0]][ints[1]] = true;
            connectNode[ints[1]][ints[0]] = true;
        }

        check[1] = true;
        list.add(1);

        while (list.size() != 0) {
            int size = list.size();
            answer = size;
            for (int i = 0; i < size; i++) {
                Integer node = list.poll();
                for (int j = 1; j <= n; j++) {
                    if (connectNode[node][j] && !check[j]) {
                        list.add(j);
                        check[j] = true;
                    }
                }
            }
        }

        return answer;
    }
}
