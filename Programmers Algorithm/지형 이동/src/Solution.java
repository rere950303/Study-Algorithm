//
// DFS, DisjointSet(지형이동)
// https://programmers.co.kr/learn/courses/30/lessons/62050?language=java
// Created by hyungwook on 2022/02/24.
//

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int length;
    ArrayList<int[]> ladder = new ArrayList<>();
    int[] arr;
    int[][] partition;

    public int solution(int[][] land, int height) {
        length = land.length;
        int num = 1;
        partition = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (partition[i][j] == 0) {
                    partition[i][j] = num;
                    dfs(land, height, num, i, j);
                    num++;
                }
            }
        }

        ladder.sort((i1, i2) -> i1[4] - i2[4]);
        int count = 0;
        arr = new int[num + 1];
        int answer = 0;

        for (int i = 1; i <= num; i++) {
            arr[i] = i;
        }

        for (int[] ladder : ladder) {
            int kind1 = Math.abs(partition[ladder[0]][ladder[1]]);
            int kind2 = Math.abs(partition[ladder[2]][ladder[3]]);

            if (find(kind1) != find(kind2)) {
                union(kind1, kind2);
                answer += ladder[4];
                count++;
            }
            if (count == num - 1) {
                break;
            }
        }

        return answer;
    }

    private void dfs(int[][] land, int height, int num, int r, int c) {
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{r, c, 0});

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();

            for (int i = pop[2]; i < 4; i++) {
                int rn = pop[0] + dir[i][0];
                int cn = pop[1] + dir[i][1];

                if (rn >= 0 && rn < length && cn >= 0 && cn < length && partition[rn][cn] == 0) {
                    int difference = Math.abs(land[rn][cn] - land[pop[0]][pop[1]]);

                    if (difference <= height) {
                        partition[rn][cn] = num;
                        stack.add(new int[]{pop[0], pop[1], i + 1});
                        stack.add(new int[]{rn, cn, 0});
                        break;
                    } else {
                        ladder.add(new int[]{pop[0], pop[1], rn, cn, difference});
                    }
                }
            }
        }
    }

    private void union(int kind1, int kind2) {
        int boss1 = find(kind1);
        int boss2 = find(kind2);

        if (boss1 != boss2) {
            arr[boss1] = boss2;
        }
    }

    private int find(int kind) {
        if (kind == arr[kind]) {
            return kind;
        } else {
            return arr[kind] = find(arr[kind]);
        }
    }
}