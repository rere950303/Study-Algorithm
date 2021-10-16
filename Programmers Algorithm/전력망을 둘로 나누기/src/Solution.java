//
// 깊이우선탐색(전력망을 둘로 나누기)
// https://programmers.co.kr/learn/courses/30/lessons/86971?language=java
// Created by hyungwook on 2021/10/10.
//

import java.util.ArrayList;

public class Solution {

    int n;
    ArrayList<ArrayList<Integer>> list;

    public int solution(int n, int[][] wires) {
        this.n = n;
        int answer = Integer.MAX_VALUE;
        list = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int[] wire : wires) {
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }

        for (int i = 0; i < n - 1; i++) {
            list.get(wires[i][0]).remove((Object) wires[i][1]);
            list.get(wires[i][1]).remove((Object) wires[i][0]);
            boolean[] check = new boolean[n + 1];
            check[1] = true;
            dfs(1, check);
            answer = Math.min(answer, count(check));
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }

        return answer;
    }

    private void dfs(int node, boolean[] check) {
        ArrayList<Integer> list = this.list.get(node);

        for (Integer integer : list) {
            if (!check[integer]) {
                check[integer] = true;
                dfs(integer, check);
            }
        }
    }

    private int count(boolean[] check) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (check[i]) {
                count++;
            }
        }
        return Math.abs(n - 2 * count);
    }
}