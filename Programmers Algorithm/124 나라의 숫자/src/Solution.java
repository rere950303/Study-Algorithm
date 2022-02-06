//
// 규칙 찾기(124 나라의 숫자)
// https://programmers.co.kr/learn/courses/30/lessons/12899?language=java
// Created by hyungwook on 2022/02/02.
//

public class Solution {

    public String solution(int n) {
        int[] radix = new int[]{4, 1, 2};
        StringBuilder answer = new StringBuilder("");

        while (n > 0) {
            int remainder = n % 3;
            answer.insert(0, radix[remainder]);
            n /= 3;
            if (remainder == 0) {
                n -= 1;
            }
        }

        return answer.toString();
    }
}