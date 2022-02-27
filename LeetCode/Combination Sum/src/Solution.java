//
// Array, DFS, Backtracking(Combination Sum)
// https://leetcode.com/problems/combination-sum/
// Created by hyungwook on 2022/02/25.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        for (int i = 0; i < candidates.length; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.add(candidates[i]);
            dfs(candidates, i, target, stack, candidates[i]);
        }

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
                stack.add(candidates[i]);
                dfs(candidates, i, target, stack, sum + candidates[i]);
                stack.pop();
            }
        }
    }
}