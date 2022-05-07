//
// Math(Closest Divisors)
// https://leetcode.com/problems/closest-divisors/
// Created by hyungwook on 2022/05/06.
//

public class Solution {

    public int[] closestDivisors(int num) {
        int[] answer = new int[2];

        for (int i = 1; i * i <= num + 2; i++) {
            if ((num + 2) % i == 0) {
                answer[0] = i;
                answer[1] = (num + 2) / i;
            }
            if ((num + 1) % i == 0) {
                answer[0] = i;
                answer[1] = (num + 1) / i;
            }
        }

        return answer;
    }
}