//
// Greedy, Math(Maximum Swap)
// https://leetcode.com/problems/maximum-swap/
// Created by hyungwook on 2022/03/27.
//

import java.util.Arrays;

public class Solution {

    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        char[] inc = String.valueOf(num).toCharArray();
        Arrays.sort(inc);

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != inc[chars.length - 1 - i]) {
                char tmp = chars[i];
                chars[i] = inc[chars.length - 1 - i];

                for (int j = chars.length - 1; j >= 0; j--) {
                    if (chars[j] == chars[i]) {
                        chars[j] = tmp;
                        break;
                    }
                }
                break;
            }
        }

        return Integer.valueOf(String.valueOf(chars));
    }
}