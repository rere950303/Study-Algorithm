//
// 규칙찾기(최고의 집합)
// https://programmers.co.kr/learn/courses/30/lessons/12938?language=java
// Created by hyungwook on 2022/02/17.
//

import java.util.Arrays;

public class Solution {

    public int[] solution(int n, int s) {
        int share = s / n;

        if (share <= 0) {
            return new int[]{-1};
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = share;
        }

        int reg = s % n;
        int idx = 0;

        while (reg > 0) {
            answer[(idx++) % n]++;
            reg--;
        }

        Arrays.sort(answer);

        return answer;
    }
}
