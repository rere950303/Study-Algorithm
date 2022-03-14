//
// BST(Construct Binary Search Tree from Preorder Traversal)
// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// Created by hyungwook on 2022/03/13.
//

public class Solution {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode curr = root;

        for (int i = 1; i < preorder.length; i++) {
            TreeNode treeNode;

            if (curr.val > preorder[i]) {
                treeNode = new TreeNode(preorder[i]);
                curr.left = treeNode;
            } else {
                treeNode = getInsertPosition(root, preorder[i]);
                TreeNode node = new TreeNode(preorder[i]);

                if (treeNode.val > preorder[i]) {
                    treeNode.left = node;
                } else {
                    treeNode.right = node;
                }
                treeNode = node;
            }
            curr = treeNode;
        }

        return root;
    }

    private TreeNode getInsertPosition(TreeNode node, int val) {
        while (true) {
            if (node.val < val) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    return node;
                }
            } else {
                if (node.left != null) {
                    node = node.left;
                } else {
                    return node;
                }
            }
        }
    }

    public static class TreeNode {
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