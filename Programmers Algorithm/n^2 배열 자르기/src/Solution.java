//
// 규칙찾기(n^2 배열 자르기)
// https://programmers.co.kr/learn/courses/30/lessons/87390?language=java
// Created by hyungwook on 2022/02/08.
//

public class Solution {

    public int[] solution(int n, long left, long right) {
        long length = right - left + 1;
        int[] answer = new int[(int) length];
        int pc = 0;

        do {
            long r = left / n;
            long c = left % n;
            long max = Math.max(r, c);

            answer[pc++] = (int) (max + 1);
            left++;
        } while (left <= right);

        return answer;
    }
}