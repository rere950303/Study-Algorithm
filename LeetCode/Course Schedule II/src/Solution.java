//
// Topological Sort, DFS(Course Schedule II)
// https://leetcode.com/problems/course-schedule-ii/
// Created by hyungwook on 2022/05/19.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            list.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] check = new int[numCourses];
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (check[i] == 0) {
                if (!dfs(list, i, check, answer)) {
                    return new int[0];
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(List<ArrayList<Integer>> list, int node, int[] check, List<Integer> answer) {
        if (check[node] > 0) {
            return check[node] == 2;
        }
        check[node] = 1;

        for (Integer to : list.get(node)) {
            if (check[to] == 2) {
                continue;
            }
            if (check[to] == 1 || !dfs(list, to, check, answer)) {
                return false;
            }
        }
        check[node] = 2;
        answer.add(node);

        return true;
    }
}