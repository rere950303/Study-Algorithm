//
// Two Pointers, String, Sliding Window(Permutation in String)
// https://leetcode.com/problems/permutation-in-string/
// Created by hyungwook on 2022/03/08.
//

public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (isAnswer(count)) {
                return true;
            }
            count[s2.charAt(i) - 'a']++;
            count[s2.charAt(i + s1.length()) - 'a']--;
        }

        return isAnswer(count);
    }

    private boolean isAnswer(int[] count) {
        for (int j : count) {
            if (j != 0) {
                return false;
            }
        }

        return true;
    }
}