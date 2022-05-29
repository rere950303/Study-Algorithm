//
// Topological Sort, DFS, Matrix, Graph(Course Schedule IV)
// https://leetcode.com/problems/course-schedule-iv/
// Created by hyungwook on 2022/05/29.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPre = new boolean[numCourses][numCourses];
        List<Boolean> answer = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            isPre[prerequisite[0]][prerequisite[1]] = true;
        }

        for (int[] query : queries) {
            if (!isPre[query[0]][query[0]]) {
                dfs(isPre, query[0]);
            }
            answer.add(isPre[query[0]][query[1]]);
        }

        return answer;
    }

    private void dfs(boolean[][] isPre, int from) {
        if (isPre[from][from]) {
            return;
        }
        boolean[] to = isPre[from];
        isPre[from][from] = true;

        for (int i = 0; i < to.length; i++) {
            if (to[i] && i != from) {
                isPre[from][i] = true;
                dfs(isPre, i);
                for (int j = 0; j < to.length; j++) {
                    if (isPre[i][j]) {
                        isPre[from][j] = true;
                    }
                }
            }
        }
    }
}