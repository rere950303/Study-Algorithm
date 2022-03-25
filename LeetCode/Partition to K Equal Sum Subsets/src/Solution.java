//
// DFS, Array, Backtracking, memoization(Partition to K Equal Sum Subsets)
// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
// Created by hyungwook on 2022/03/24.
//

import java.util.Arrays;

public class Solution {

    boolean[] isVisit;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        isVisit = new boolean[nums.length];

        if (sum % k != 0) {
            return false;
        }
        int equalSum = sum / k;

        return dfs(nums, equalSum, equalSum, 0, k);
    }

    private boolean dfs(int[] nums, int sum, int equalSum, int l, int k) {
        if (k == 0) {
            return true;
        }
        if (sum == 0) {
            return dfs(nums, equalSum, equalSum, 0, k - 1);
        }
        for (int i = l; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !isVisit[i - 1]) {
                continue;
            }
            if (!isVisit[i] && sum >= nums[i]) {
                isVisit[i] = true;
                if (dfs(nums, sum - nums[i], equalSum, i + 1, k)) {
                    return true;
                }
                isVisit[i] = false;
            }
        }

        return false;
    }
}