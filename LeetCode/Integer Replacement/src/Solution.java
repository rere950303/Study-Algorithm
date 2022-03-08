//
// Greedy, Bit Manipulation, Memorization(Integer Replacement)
// https://leetcode.com/problems/integer-replacement/
// Created by hyungwook on 2022/03/06.
//

public class Solution {

    public int integerReplacement(int n) {
        int answer = 0;

        while (n != 1) {
            if (n % 2 == 1) {
                int sub = n - 1;

                if (sub == 2 || (sub / 2) % 2 == 0) {
                    n -= 1;
                } else {
                    n += 1;
                }
                answer++;
            } else {
                for (int i = 31; i >= 1; i--) {
                    if (n % (1 << i) == 0) {
                        n = n / (1 << i);
                        answer += i;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}