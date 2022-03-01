//
// DFS, Array(Jump Game III)
// https://leetcode.com/problems/jump-game-iii/
// Created by hyungwook on 2022/03/01.
//

public class Solution {

    boolean flag = false;
    int length;
    boolean[] check;

    public boolean canReach(int[] arr, int start) {
        this.length = arr.length;
        this.check = new boolean[length];

        dfs(arr, start);

        return flag;
    }

    private void dfs(int[] arr, int start) {
        if (start < 0 || start >= length || check[start] || flag) {
            return;
        }
        if (arr[start] == 0) {
            flag = true;
            return;
        }
        check[start] = true;
        dfs(arr, start + arr[start]);
        dfs(arr, start - arr[start]);
    }
}