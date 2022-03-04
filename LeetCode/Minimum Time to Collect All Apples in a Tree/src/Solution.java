//
// Tree, DFS, Hash Table(Minimum Time to Collect All Apples in a Tree)
// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
// Created by hyungwook on 2022/03/04.
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    List<Boolean> hasApple;
    boolean[] isVisit;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.isVisit = new boolean[n];
        this.hasApple = hasApple;
        HashMap<Integer, Node> map = new HashMap<>();

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            Node parent = map.getOrDefault(from, new Node(from));
            Node child = map.getOrDefault(to, new Node(to));

            parent.children.add(child);
            child.children.add(parent);

            map.put(from, parent);
            map.put(to, child);
        }

        Node root = map.get(0);
        isVisit[0] = true;

        return Math.max(0, dfs(root) - 2);
    }

    private int dfs(Node node) {
        if (node == null) {
            return 0;
        }
        int traverseNum = 0;

        for (Node child : node.children) {
            if (!isVisit[child.n]) {
                isVisit[child.n] = true;
                traverseNum += dfs(child);
            }
        }

        if (traverseNum == 0 && !hasApple.get(node.n)) {
            return 0;
        } else {
            return traverseNum + 2;
        }
    }

    static class Node {
        int n;
        List<Node> children = new ArrayList<>();

        public Node(int n) {
            this.n = n;
        }
    }
}