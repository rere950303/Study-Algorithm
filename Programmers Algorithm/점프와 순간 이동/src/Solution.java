//
// 규칙찾기(점프와 순간 이동)
// https://programmers.co.kr/learn/courses/30/lessons/12980?language=java
// Created by hyungwook on 2022/02/08.
//

public class Solution {

    public int solution(int n) {
        int answer = 0;

        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                answer++;
                n--;
            }
        }

        return answer;
    }
}
