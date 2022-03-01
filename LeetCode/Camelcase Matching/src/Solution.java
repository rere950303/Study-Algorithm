//
// Two Pointers, String, Trie, String Matching(Camelcase Matching)
// https://leetcode.com/problems/camelcase-matching/
// Created by hyungwook on 2022/02/28.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> answer = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            int idx1 = 0;
            int idx2 = 0;
            boolean flag = true;

            while (idx1 < query.length()) {
                if (idx2 < pattern.length() && query.charAt(idx1) == pattern.charAt(idx2)) {
                    idx1++;
                    idx2++;
                } else if (Character.isUpperCase(query.charAt(idx1)) && (idx2 == pattern.length() || query.charAt(idx1) != pattern.charAt(idx2))) {
                    flag = false;
                    break;
                } else {
                    idx1++;
                }
            }

            if (flag && idx2 == pattern.length()) {
                answer.add(true);
            } else {
                answer.add(false);
            }
        }

        return answer;
    }
}