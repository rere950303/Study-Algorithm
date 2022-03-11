//
// Graph(Minimum Number of Vertices to Reach All Nodes)
// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
// Created by hyungwook on 2022/03/11.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] hasIncomingEdge = new boolean[n];

        for (List<Integer> edge : edges) {
            hasIncomingEdge[edge.get(1)] = true;
        }
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!hasIncomingEdge[i]) {
                answer.add(i);
            }
        }

        return answer;
    }
}