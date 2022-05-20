//
// Greedy, Two Pointers, Hash Table(Partition Labels)
// https://leetcode.com/problems/partition-labels/
// Created by hyungwook on 2022/05/09.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> partitionLabels(String s) {
        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a'] = i;
        }

        List<Integer> answer = new ArrayList<>();
        int startIdx = 0;
        int lastIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            lastIdx = Math.max(lastIdx, alphabet[s.charAt(i) - 'a']);

            if (lastIdx == i) {
                answer.add(i - startIdx + 1);
                startIdx = i + 1;
                lastIdx = startIdx;
            }
        }

        return answer;
    }
}