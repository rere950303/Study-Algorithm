//
// Greedy algorithms(TieRopes)
// https://app.codility.com/programmers/lessons/16-greedy_algorithms/tie_ropes/
// Created by hyungwook on 2022/01/30.
//

public class Solution {

    public int solution(int K, int[] A) {
        int answer = 0;
        int tmp = 0;

        for (int a : A) {
            tmp += a;

            if (tmp >= K) {
                answer++;
                tmp = 0;
            }
        }

        return answer;
    }
}