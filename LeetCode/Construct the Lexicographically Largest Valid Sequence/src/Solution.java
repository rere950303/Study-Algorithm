//
// DFS, Backtracking, Array(Construct the Lexicographically Largest Valid Sequence)
// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
// Created by hyungwook on 2022/03/17.
//

public class Solution {

    public int[] constructDistancedSequence(int n) {
        int length = 1 + (n - 1) * 2;
        int[] answer = new int[length];
        boolean[] check = new boolean[n];

        dfs(0, check, answer);

        return answer;
    }

    private boolean dfs(int l, boolean[] check, int[] answer) {
        if (l == answer.length) {
            return true;
        }
        if (answer[l] != 0) {
            return dfs(l + 1, check, answer);
        } else {
            for (int i = 0; i < check.length; i++) {
                int num = check.length - i;

                if (!check[i] && (num == 1 || l + num < answer.length && answer[l + num] == 0)) {
                    answer[l] = num;
                    check[i] = true;
                    if (num != 1) {
                        answer[l + num] = num;
                    }

                    if (dfs(l + 1, check, answer)) {
                        return true;
                    }
                    answer[l] = 0;
                    if (num != 1) {
                        answer[l + num] = 0;
                    }
                    check[i] = false;
                }
            }
        }

        return false;
    }
}