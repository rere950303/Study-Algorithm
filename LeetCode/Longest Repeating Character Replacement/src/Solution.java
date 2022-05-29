//
// Sliding Window, Hash Table, String(Longest Repeating Character Replacement)
// https://leetcode.com/problems/longest-repeating-character-replacement/
// Created by hyungwook on 2022/05/25.
//

import java.util.HashMap;

public class Solution {

    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int pl = 0;
        int pr = 0;
        int max = 0;

        for (; pr < s.length(); pr++) {
            map.merge(s.charAt(pr), 1, (o, n) -> o + 1);
            max = Math.max(max, map.get(s.charAt(pr)));

            if (pr - pl + 1 - max > k) {
                map.put(s.charAt(pl), map.get(s.charAt(pl)) - 1);
                pl++;
            }
        }

        return pr - pl;
    }
}