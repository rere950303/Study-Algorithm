//
// DFS, Backtracking, String(Additive Number)
// https://leetcode.com/problems/additive-number/
// Created by hyungwook on 2022/05/06.
//

import java.math.BigInteger;

public class Solution {

    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() / 2; i++) {
            if (i > 1 && num.charAt(0) == '0') break;
            for (int j = 1; j <= num.length() / 2; j++) {
                if (j > 1 && num.charAt(i) == '0') break;
                BigInteger bigInteger1 = new BigInteger(num.substring(0, i));
                BigInteger bigInteger2 = new BigInteger(num.substring(i, i + j));

                if (dfs(num, i + j, 0, bigInteger1, bigInteger2)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(String num, int start, int l, BigInteger bigInteger1, BigInteger bigInteger2) {
        if (start == num.length() && l > 0) {
            return true;
        }
        String sum = String.valueOf(bigInteger1.add(bigInteger2));
        int idx = num.indexOf(sum, start);

        if (idx != start) {
            return false;
        } else {
            return dfs(num, start + sum.length(), l + 1, bigInteger2, new BigInteger(sum));
        }
    }
}