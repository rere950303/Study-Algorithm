//
// Sorting, Hash Table, String(Custom Sort String)
// https://leetcode.com/problems/custom-sort-string/
// Created by hyungwook on 2022/06/22.
//

public class Solution {

    public String customSortString(String order, String s) {
        char[] chars = new char[26];

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();

        for (char c : order.toCharArray()) {
            while (chars[c - 'a'] > 0) {
                builder.append(c);
                chars[c - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                while (chars[i] > 0) {
                    builder.append((char) (i + 'a'));
                    chars[i]--;
                }
            }
        }

        return builder.toString();
    }
}