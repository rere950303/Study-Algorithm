//
// Backtracking, Tree, DFS, Stack(Path Sum II)
// https://leetcode.com/problems/path-sum-ii/
// Created by hyungwook on 2022/02/24.
//

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return answer;
        }

        dfs(root, 0, targetSum, new Stack<>());

        return answer;
    }

    private void dfs(TreeNode node, int sum, int targetSum, Stack<Integer> tmp) {
        tmp.push(node.val);
        sum += node.val;

        if (node.left == null && node.right == null) {
            if (targetSum == sum) {
                answer.add(new ArrayList<>(tmp));
            }
        } else {
            if (node.left != null) {
                dfs(node.left, sum, targetSum, tmp);
            }
            if (node.right != null) {
                dfs(node.right, sum, targetSum, tmp);
            }
        }
        tmp.pop();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
