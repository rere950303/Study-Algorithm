//
// BFS, Tree(Check Completeness of a Binary Tree)
// https://leetcode.com/problems/check-completeness-of-a-binary-tree/
// Created by hyungwook on 2022/03/14.
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int prevCount = 2;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int count = 0;

                if (node.left == null && node.right != null) {
                    return false;
                }
                if (node.left != null) {
                    queue.add(node.left);
                    count++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    count++;
                }
                if ((prevCount == 0 || prevCount == 1) && (count == 1 || count == 2)) {
                    return false;
                }
                prevCount = count;
            }
        }

        return true;
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