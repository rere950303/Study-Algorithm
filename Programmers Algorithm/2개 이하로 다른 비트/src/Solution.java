//
// 규칙찾기(2개 이하로 다른 비트)
// https://programmers.co.kr/learn/courses/30/lessons/77885?language=java
// Created by hyungwook on 2022/02/06.
//

public class Solution {

    public long[] solution(long[] numbers) {
        int length = numbers.length;
        long[] answer = new long[length];

        for (int i = 0; i < length; i++) {
            int count = 0;
            long number = numbers[i];

            for (int j = 0; j < 64; j++) {
                if ((number & 1L << j) > 0) {
                    count++;
                } else {
                    break;
                }
            }

            answer[i] = number + (long) Math.ceil(Math.pow(2, count - 1));
        }

        return answer;
    }
}