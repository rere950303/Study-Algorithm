//
// Math, String(Number of Substrings With Only 1s)
// https://leetcode.com/problems/number-of-substrings-with-only-1s/
// Created by hyungwook on 2022/03/01.
//

public class Solution {

    public int numSub(String s) {
        int answer = 0;
        int tmp = 1;
        int modulo = (int) Math.pow(10, 9) + 7;


        for (char c : s.toCharArray()) {
            if (c == '0') {
                tmp = 1;
            } else {
                answer = (answer + tmp++) % modulo;
            }
        }

        return answer;
    }
}