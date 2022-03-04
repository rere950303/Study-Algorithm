//
// Tree, DFS(Count Nodes With the Highest Score)
// https://leetcode.com/problems/count-nodes-with-the-highest-score/
// Created by hyungwook on 2022/03/02.
//

import java.util.HashMap;

public class Solution {

    long max = Integer.MIN_VALUE;
    long answer = 0;
    int length;

    public int countHighestScoreNodes(int[] parents) {
        this.length = parents.length;
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(0, new Node(0));

        for (int i = 1; i < length; i++) {
            Node child = map.containsKey(i) ? map.get(i) : new Node(i);
            Node parent = map.containsKey(parents[i]) ? map.get(parents[i]) : new Node(parents[i]);

            if (parent.lt == null) {
                parent.lt = child;
            } else {
                parent.rt = child;
            }

            map.put(i, child);
            map.put(parents[i], parent);
        }

        dfs(map.get(0));

        return (int) answer;
    }

    private long dfs(Node node) {
        if (node.lt != null) {
            node.lSubtree = dfs(node.lt);
        }
        if (node.rt != null) {
            node.rSubtree = dfs(node.rt);
        }
        long remain = length - node.lSubtree - node.rSubtree - 1;
        long prod = (node.lSubtree > 0 ? node.lSubtree : 1) * (node.rSubtree > 0 ? node.rSubtree : 1) * (remain > 0 ? remain : 1);

        if (prod == max) {
            answer++;
        } else if (prod > max) {
            max = prod;
            answer = 1;
        }

        return node.lSubtree + node.rSubtree + 1;
    }

    static class Node {
        int n;
        long lSubtree;
        long rSubtree;
        Node lt;
        Node rt;

        public Node(int n) {
            this.n = n;
        }
    }
}