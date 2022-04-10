//
// DFS, Backtracking, Hash Table(Increasing Subsequences)
// https://leetcode.com/problems/increasing-subsequences/
// Created by hyungwook on 2022/04/07.
//

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, tmp, 0);

        return answer;
    }

    private void dfs(int[] nums, List<Integer> tmp, int l) {
        if (tmp.size() > 1) {
            answer.add(new ArrayList<>(tmp));
        }
        HashSet<Integer> set = new HashSet<>();

        for (int i = l; i < nums.length; i++) {
            if (tmp.size() > 0 && nums[i] < tmp.get(tmp.size() - 1) || set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            tmp.add(nums[i]);
            dfs(nums, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}