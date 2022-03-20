//
// DFS, Binary Tree(Number of Good Leaf Nodes Pairs)
// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
// Created by hyungwook on 2022/03/19.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int answer = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);

        return answer;
    }

    private List<Integer> dfs(TreeNode node, int distance) {
        if (node == null) {
            return new ArrayList<>();
        }
        if (node.left == null && node.right == null) {
            List<Integer> sublist = new ArrayList<>();
            sublist.add(1);
            return sublist;
        }
        List<Integer> l = dfs(node.left, distance);
        List<Integer> r = dfs(node.right, distance);

        for (int d1 : l) {
            for (int d2 : r) {
                if (d1 + d2 <= distance) {
                    answer++;
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int val : l) {
            list.add(val + 1);
        }
        for (int val : r) {
            list.add(val + 1);
        }

        return list;
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