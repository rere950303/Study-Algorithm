//
// DFS(하노이의 탑)
// https://programmers.co.kr/learn/courses/30/lessons/12946?language=java
// Created by hyungwook on 2022/02/17.
//

import java.util.ArrayList;

public class Solution {

    ArrayList<int[]> answer = new ArrayList<>();

    public int[][] solution(int n) {

        move(n, 1, 3);

        return answer.stream().toArray(int[][]::new);
    }

    private void move(int n, int from, int to) {
        if (n == 1) {
            answer.add(new int[]{from, to});
            return;
        }
        move(n - 1, from, 6 - from - to);
        move(1, from, to);
        move(n - 1, 6 - from - to, to);
    }
}