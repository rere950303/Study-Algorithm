//
// Math(Reverse Integer)
// https://leetcode.com/problems/reverse-integer/
// Created by hyungwook on 2022/02/23.
//

public class Solution {

    public int reverse(int x) {
        int answer = 0;

        while (x != 0) {
            int remainder = x % 10;
            x /= 10;

            if (answer > Integer.MAX_VALUE / 10 || (answer == Integer.MAX_VALUE / 10 && remainder > 7)) {
                return 0;
            }
            if (answer < Integer.MIN_VALUE / 10 || (answer == Integer.MIN_VALUE / 10 && remainder < -8)) {
                return 0;
            }

            answer = answer * 10 + remainder;
        }

        return answer;
    }
}