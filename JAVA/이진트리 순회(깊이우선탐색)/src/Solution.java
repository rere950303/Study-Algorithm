//
// 이진트리 순회(깊이우선탐색)
//
// Created by hyungwook on 2021/10/04.
//

public class Solution {

    public static void main(String[] args) {
        Node rootNode = new Node(1);
        Node node = rootNode.addLeftNode(new Node(2));
        node.addLeftNode(new Node(4));
        node.addRightNode(new Node(5));
        Node node1 = rootNode.addRightNode(new Node(3));
        node1.addLeftNode(new Node(6));
        node1.addRightNode(new Node(7));

        preorder(rootNode);
        System.out.println();
        inorder(rootNode);
        System.out.println();
        postorder(rootNode);
    }

    private static void preorder(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.data + " ");
            preorder(node.lt);
            preorder(node.rt);
        }
    }

    private static void inorder(Node node) {
        if (node == null) {
            return;
        } else {
            inorder(node.lt);
            System.out.print(node.data + " ");
            inorder(node.rt);
        }
    }

    private static void postorder(Node node) {
        if (node == null) {
            return;
        } else {
            postorder(node.lt);
            postorder(node.rt);
            System.out.print(node.data + " ");
        }
    }

    static class Node {
        int data;
        Node lt;
        Node rt;

        public Node(int data) {
            this.data = data;
        }

        public Node addLeftNode(Node node) {
            this.lt = node;
            return node;
        }

        public Node addRightNode(Node node) {
            this.rt = node;
            return node;
        }
    }
}