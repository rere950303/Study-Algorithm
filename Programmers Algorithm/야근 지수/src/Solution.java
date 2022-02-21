//
// 규칙찾기(야근 지수)
// https://programmers.co.kr/learn/courses/30/lessons/12927
// Created by hyungwook on 2022/02/15.
//

public class Solution {

    public long solution(int n, int[] works) {
        long answer = 0;
        int[] arr = new int[50001];

        for (int work : works) {
            arr[work]++;
        }

        for (int i = 50000; i >= 1; i--) {
            if (arr[i] != 0) {
                int count = Math.min(n, arr[i]);

                arr[i - 1] += count;
                arr[i] -= count;
                n -= count;

                if (n == 0) {
                    break;
                }
            }
        }

        for (int i = 1; i <= 50000; i++) {
            if (arr[i] != 0) {
                answer += Math.pow(i, 2) * arr[i];
            }
        }

        return answer;
    }
}