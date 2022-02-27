//
// Array, Backtracking(Permutations II)
// https://leetcode.com/problems/permutations-ii/
// Created by hyungwook on 2022/02/25.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    boolean[] check;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        check = new boolean[nums.length];
        dfs(nums, new ArrayList<>());

        return answer;
    }

    private void dfs(int[] nums, ArrayList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            answer.add(new ArrayList<>(tmp));
        } else {
            int prev = -11;
            for (int i = 0; i < nums.length; i++) {
                if (!check[i] && nums[i] != prev) {
                    prev = nums[i];
                    check[i] = true;
                    tmp.add(nums[i]);
                    dfs(nums, tmp);
                    tmp.remove(tmp.size() - 1);
                    check[i] = false;
                }
            }
        }
    }
}