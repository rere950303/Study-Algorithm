//
// 문자열(JadenCase 문자열 만들기)
// https://programmers.co.kr/learn/courses/30/lessons/12951?language=java
// Created by hyungwook on 2022/02/18.
//

public class Solution {

    public String solution(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int length = chars.length;

        for (int i = 0; i < length; i++) {
            if ((i == 0 && Character.isAlphabetic(chars[i])) || i != 0 && chars[i - 1] == ' ' && Character.isAlphabetic(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }

        return new String(chars);
    }
}