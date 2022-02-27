//
// String, DP, Backtracking(Generate Parentheses)
// https://leetcode.com/problems/generate-parentheses/
// Created by hyungwook on 2022/02/24.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    ArrayList<String> answer = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");

        return answer;
    }

    private void dfs(int n, int open, int end, String tmp) {
        if (open == n && end == n) {
            answer.add(tmp);
            return;
        }
        if (open > n || end > open) {
            return;
        }
        dfs(n, open + 1, end, tmp + "(");
        dfs(n, open, end + 1, tmp + ")");
    }
}