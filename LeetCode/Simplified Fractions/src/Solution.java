//
// Math, String, GCD, Number Theory(Simplified Fractions)
// https://leetcode.com/problems/simplified-fractions/
// Created by hyungwook on 2022/02/27.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> simplifiedFractions(int n) {
        List<String> answer = new ArrayList<>();

        for (int i = n; i > 1; i--) {
            addFraction(answer, i);
        }

        return answer;
    }

    private void addFraction(List<String> answer, int denominator) {
        for (int i = 1; i < denominator; i++) {
            if (gcd(i, denominator) == 1) {
                answer.add(i + "/" + denominator);
            }
        }
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
