//
// DFS, Graph(Course Schedule)
// https://leetcode.com/problems/course-schedule/
// Created by hyungwook on 2022/05/13.
//

import java.util.*;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            map.get(prerequisite[0]).add(prerequisite[1]);
        }
        HashSet<Integer> set = new HashSet<>();
        boolean[] check = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            set.add(i);
            if (!dfs(check, set, map, i)) {
                return false;
            }
            set.remove(i);
        }

        return true;
    }

    private boolean dfs(boolean[] check, HashSet<Integer> set, HashMap<Integer, List<Integer>> map, int course) {
        List<Integer> prerequisites = map.get(course);

        for (Integer prerequisite : prerequisites) {
            if (check[prerequisite]) {
                continue;
            }
            if (set.contains(prerequisite)) {
                return false;
            }
            set.add(prerequisite);
            if (!dfs(check, set, map, prerequisite)) {
                return false;
            }
            set.remove(prerequisite);
        }

        return check[course] = true;
    }
}