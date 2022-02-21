//
// 규칙찾기(이진 변환 반복하기)
// https://programmers.co.kr/learn/courses/30/lessons/70129?language=java
// Created by hyungwook on 2022/02/07.
//

public class Solution {

    public int[] solution(String s) {
        int count = 0;
        int removeNum = 0;

        while (!s.equals("1")) {
            int length = s.length();

            s = s.replace("0", "");
            removeNum += length - s.length();
            s = makeRadix(s.length());
            count++;
        }

        int[] answer = {count, removeNum};

        return answer;
    }

    private String makeRadix(int length) {
        StringBuilder stringBuilder = new StringBuilder();

        while (length > 0) {
            stringBuilder.append(length % 2);
            length /= 2;
        }

        return stringBuilder.reverse().toString();
    }
}