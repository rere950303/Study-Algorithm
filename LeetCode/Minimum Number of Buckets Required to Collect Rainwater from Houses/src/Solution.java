//
// Greedy, DP(Minimum Number of Buckets Required to Collect Rainwater from Houses)
// https://leetcode.com/problems/minimum-number-of-buckets-required-to-collect-rainwater-from-houses/
// Created by hyungwook on 2022/05/13.
//

public class Solution {

    public int minimumBuckets(String street) {
        if (street.length() == 1) {
            return street.charAt(0) == '.' ? 0 : -1;
        }
        char[] chars = street.toCharArray();
        int answer = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                continue;
            }
            if (!canCollect(chars, i)) {
                return -1;
            }
            if (i < chars.length - 2 && chars[i + 2] == 'H' && chars[i + 1] == '.') {
                i += 2;
            }
            answer++;
        }

        return answer;
    }

    private boolean canCollect(char[] chars, int i) {
        if (i == 0) {
            return chars[i + 1] == '.';
        } else if (i == chars.length - 1) {
            return chars[i - 1] == '.';
        } else {
            return chars[i - 1] == '.' || chars[i + 1] == '.';
        }
    }
}