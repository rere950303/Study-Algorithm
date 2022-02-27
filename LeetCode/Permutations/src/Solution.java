//
// Array, Backtracking(Permutations)
// https://leetcode.com/problems/permutations/
// Created by hyungwook on 2022/02/25.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    boolean[] check;
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        check = new boolean[nums.length];
        dfs(new ArrayList(), nums);

        return answer;
    }

    private void dfs(List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            answer.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    tmp.add(nums[i]);
                    dfs(tmp, nums);
                    check[i] = false;
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}