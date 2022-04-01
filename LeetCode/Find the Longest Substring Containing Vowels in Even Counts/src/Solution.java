//
// Hash Table, Bit Manipulation, Prefix Sum(Find the Longest Substring Containing Vowels in Even Counts)
// https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
// Created by hyungwook on 2022/03/28.
//

import java.util.HashMap;

public class Solution {

    public int findTheLongestSubstring(String s) {
        HashMap<Character, Integer> vowel = new HashMap<>();
        vowel.put('a', 1);
        vowel.put('e', 2);
        vowel.put('i', 4);
        vowel.put('o', 8);
        vowel.put('u', 16);
        HashMap<Integer, Integer> bitMask = new HashMap<>();
        int x = 0;
        bitMask.put(0, -1);

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (vowel.containsKey(c)) {
                x ^= vowel.get(c);
            }
            if (bitMask.containsKey(x)) {
                answer = Math.max(answer, i - bitMask.get(x));
            } else {
                bitMask.put(x, i);
            }
        }

        return answer;
    }
}