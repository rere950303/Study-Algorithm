//
// Greedy, Array, DP(Greatest Sum Divisible by Three)
// https://leetcode.com/problems/greatest-sum-divisible-by-three/
// Created by hyungwook on 2022/09/16.
//

public class Solution {

    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int oneRemainder = 10000;
        int twoRemainder = 10000;

        for (int num : nums) {
            sum += num;

            if (num % 3 == 1) {
                twoRemainder = Math.min(twoRemainder, oneRemainder + num);
                oneRemainder = Math.min(oneRemainder, num);
            } else if (num % 3 == 2) {
                oneRemainder = Math.min(oneRemainder, twoRemainder + num);
                twoRemainder = Math.min(twoRemainder, num);
            }
        }

        if (sum % 3 == 0) {
            return sum;
        } else if (sum % 3 == 1) {
            return sum - oneRemainder;
        }
        return sum - twoRemainder;
    }
}