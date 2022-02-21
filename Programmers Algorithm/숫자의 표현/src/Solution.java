//
// 규칙찾기(숫자의 표현)
// https://programmers.co.kr/learn/courses/30/lessons/12924
// Created by hyungwook on 2022/02/10.
//

public class Solution {

    public int solution(int n) {
        int start = 0;
        int end = 1;
        int sum = 0;
        int answer = 0;

        while (end <= n + 1) {
            if (sum < n) {
                sum += end++;
            } else if (sum == n) {
                sum += (end++ - start++);
                answer++;
            } else {
                sum -= start++;
            }
        }

        return answer;
    }
}
