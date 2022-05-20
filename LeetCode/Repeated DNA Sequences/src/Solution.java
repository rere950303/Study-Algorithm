//
// Sliding Window, Hash Table, String(Repeated DNA Sequences)
// https://leetcode.com/problems/repeated-dna-sequences/
// Created by hyungwook on 2022/05/20.
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return List.of();
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            builder.append(s.charAt(i));
        }
        HashMap<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();


        for (int i = 9; i < s.length(); i++) {
            builder.append(s.charAt(i));
            String key = builder.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);

            if (map.get(key) == 2) {
                answer.add(key);
            }
            builder.deleteCharAt(0);
        }

        return answer;
    }
}