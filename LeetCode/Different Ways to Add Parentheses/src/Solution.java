//
// Recursion, Memoization, String, DP(Different Ways to Add Parentheses)
// https://leetcode.com/problems/different-ways-to-add-parentheses/
// Created by hyungwook on 2022/05/03.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<Integer> diffWaysToCompute(String expression) {
        Integer[] nums = Arrays.stream(expression.split("[+*-]"))
                .map(Integer::valueOf).toArray(Integer[]::new);

        if (nums.length == 1) {
            return List.of(nums[0]);
        }
        String[] op = expression.split("[\\d]+");
        op = Arrays.copyOfRange(op, 1, op.length);

        return dfs(0, nums.length - 1, nums, op);
    }

    private List<Integer> dfs(int start, int end, Integer[] nums, String[] op) {
        if (start == end) {
            return List.of(nums[start]);
        } else {
            List<Integer> list = new ArrayList<>();

            for (int i = start; i < end; i++) {
                List<Integer> tmp1 = dfs(start, i, nums, op);
                List<Integer> tmp2 = dfs(i + 1, end, nums, op);

                for (Integer num1 : tmp1) {
                    for (Integer num2 : tmp2) {
                        list.add(cal(num1, num2, i, op));
                    }
                }
            }

            return list;
        }
    }

    private int cal(int num1, int num2, int opIdx, String[] op) {
        if (op[opIdx].equals("+")) {
            return num1 + num2;
        } else if (op[opIdx].equals("-")) {
            return num1 - num2;
        } else {
            return num1 * num2;
        }
    }
}