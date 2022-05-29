//
// Sliding Window, String(Swap For Longest Repeated Character Substring)
// https://leetcode.com/problems/swap-for-longest-repeated-character-substring/
// Created by hyungwook on 2022/05/27.
//

class Solution {

    public int maxRepOpt1(String text) {
        int[] count = new int[26];
        int n = text.length();

        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int start = 0;
        int answer = 1;

        while (start < n) {
            int end = start;
            char curr = text.charAt(start);

            while (end < n && text.charAt(end) == curr) {
                end++;
            }
            int tmp = end;

            while (end + 1 < n && text.charAt(end + 1) == curr) {
                end++;
            }
            int len = end - start;
            if (count[curr - 'a'] > len) {
                len++;
            }

            answer = Math.max(answer, len);
            start = tmp;
        }

        return answer;
    }
}