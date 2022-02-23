//
// Hash Table, String, Sliding Window(Longest Substring Without Repeating Characters)
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Created by hyungwook on 2022/02/23.
//

import java.util.HashMap;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int pl = 0;
        int pr = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int answer = 0;

        while (pr < length) {
            char c = s.charAt(pr);

            if (map.containsKey(c)) {
                pl = Math.max(pl, map.get(c));
            }
            answer = Math.max(answer, pr - pl + 1);
            map.put(c, pr + 1);
            pr++;
        }

        return answer;
    }

}
