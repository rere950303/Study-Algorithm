//
// String, DP(Longest Palindromic Substring)
// https://leetcode.com/problems/longest-palindromic-substring/
// Created by hyungwook on 2022/02/23.
//

public class Solution {

    int length;
    String s;

    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return "";
        }

        this.length = s.length();
        this.s = s;
        int start = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            int len1 = expandPandlinrom(i - 1, i + 1);
            int len2 = expandPandlinrom(i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandPandlinrom(int pl, int pr) {
        while (pl >= 0 && pr < length && s.charAt(pl) == s.charAt(pr)) {
            pl--;
            pr++;
        }

        return pr - pl - 1;
    }
}