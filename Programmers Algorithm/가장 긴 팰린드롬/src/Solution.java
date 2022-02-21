//
// for문(가장 긴 팰린드롬)
// https://programmers.co.kr/learn/courses/30/lessons/12904?language=java
// Created by hyungwook on 2022/02/12.
//

public class Solution {

    public int solution(String s) {
        int length = s.length();

        for (int i = length; i >= 0; i--) {
            int tmp = length - i;

            for (int j = 0; j <= tmp; j++) {
                if (isPalindrome(s, j, j + i - 1)) {
                    return i;
                }
            }
        }

        return 0;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}