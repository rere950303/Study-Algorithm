//
// DFS, Backtracking, String(Palindrome Partitioning)
// https://leetcode.com/problems/palindrome-partitioning/
// Created by hyungwook on 2022/05/06.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<String> tmp = new ArrayList<>();
        dfs(s, tmp, 0);

        return answer;
    }

    private void dfs(String s, List<String> tmp, int start) {
        if (start == s.length()) {
            answer.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tmp.add(s.substring(start, i + 1));
                    dfs(s, tmp, i + 1);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}