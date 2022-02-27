//
// Array, DFS, Backtracking(Combination Sum II)
// https://leetcode.com/problems/combination-sum-ii/
// Created by hyungwook on 2022/02/25.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Stack<Integer> stack = new Stack<>();
        dfs(candidates, 0, target, stack, 0);

        return answer;
    }

    private void dfs(int[] candidates, int start, int target, Stack<Integer> stack, int sum) {
        if (sum == target) {
            ArrayList<Integer> list = new ArrayList<>(stack);
            answer.add(list);
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (sum + candidates[i] > target) {
                    return;
                }
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                stack.add(candidates[i]);
                dfs(candidates, i + 1, target, stack, sum + candidates[i]);
                stack.pop();
            }
        }
    }
}