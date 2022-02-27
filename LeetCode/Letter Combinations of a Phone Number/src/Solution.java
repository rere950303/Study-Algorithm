//
// String, DFS, Backtracking(Letter Combinations of a Phone Number)
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Created by hyungwook on 2022/02/25.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    ArrayList<String> answer = new ArrayList<>();
    String key[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.equals("")) {
            return answer;
        }

        dfs(digits, 0, digits.length(), "");

        return answer;
    }

    private void dfs(String digits, int l, int length, String tmp) {
        if (l == length) {
            answer.add(tmp);
        } else {
            for (char c : key[digits.charAt(l) - '0'].toCharArray()) {
                dfs(digits, l + 1, length, tmp + c);
            }
        }
    }
}