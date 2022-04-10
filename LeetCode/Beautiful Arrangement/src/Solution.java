//
// DFS, Backtracking(Beautiful Arrangement)
// https://leetcode.com/problems/beautiful-arrangement/
// Created by hyungwook on 2022/04/05.
//

public class Solution {

    boolean[] check;
    int answer = 0;

    public int countArrangement(int n) {
        this.check = new boolean[n + 1];

        dfs(check, 1);

        return answer;
    }

    private void dfs(boolean[] nums, int l) {
        if (l == nums.length) {
            answer++;
        } else {
            for (int i = 1; i < nums.length; i++) {
                if (!check[i] && (l % i == 0 || i % l == 0)) {
                    check[i] = true;
                    dfs(nums, l + 1);
                    check[i] = false;
                }
            }
        }
    }
}