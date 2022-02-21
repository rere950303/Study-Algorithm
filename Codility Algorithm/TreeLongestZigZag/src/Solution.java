//
// Data Structures(TreeLongestZigZag)
// https://app.codility.com/programmers/trainings/7/tree_longest_zig_zag/
// Created by hyungwook on 2022/02/20.
//

public class Solution {

    int answer = Integer.MIN_VALUE;

    public int solution(Tree T) {
        dfs(T, 0, 0);

        return answer;
    }

    private void dfs(Tree node, int dir, int zigzag) {
        if (node.l == null && node.r == null) {
            answer = Math.max(answer, zigzag);
        } else {
            if (node.l != null) {
                dfs(node.l, -1, zigzag - Math.min(dir * -1, 0));
            }
            if (node.r != null) {
                dfs(node.r, 1, zigzag - Math.min(dir * 1, 0));
            }
        }
    }

    static class Tree {
        int x;
        Tree l;
        Tree r;

        public Tree(int x) {
            this.x = x;
        }
    }
}