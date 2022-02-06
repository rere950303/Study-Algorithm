//
// 규칙 찾기(예상 대진표)
// https://programmers.co.kr/learn/courses/30/lessons/12985
// Created by hyungwook on 2022/02/03.
//

public class Solution {

    public int solution(int n, int a, int b) {
        int answer = 1;
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        a = min;
        b = max;

        while (!(a % 2 == 1 && a + 1 == b)) {
            a = (int) Math.ceil((double) a / 2);
            b = (int) Math.ceil((double) b / 2);
            answer++;
        }

        return answer;
    }
}