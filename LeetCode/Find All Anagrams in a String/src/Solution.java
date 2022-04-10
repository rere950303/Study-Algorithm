//
// Sliding Window, String(Find All Anagrams in a String)
// https://leetcode.com/problems/find-all-anagrams-in-a-string/
// Created by hyungwook on 2022/04/04.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] alphabet = new int[26];

        for (int i = 0; i < p.length(); i++) {
            alphabet[s.charAt(i) - 'a']--;
            alphabet[p.charAt(i) - 'a']++;
        }
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (isAnagram(alphabet)) {
                answer.add(i);
            }
            alphabet[s.charAt(i) - 'a']++;
            if (i + p.length() < s.length()) {
                alphabet[s.charAt(i + p.length()) - 'a']--;
            }
        }

        return answer;
    }

    private boolean isAnagram(int[] alphabet) {
        for (int c : alphabet) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}