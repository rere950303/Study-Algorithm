//
// 경로 탐색(인접행렬)
//
// Created by hyungwook on 2021/10/06.
//

import java.util.Scanner;

public class Solution {

    static boolean[] check;
    static int[][] graph;
    static int answer = 0;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        check = new boolean[n + 1];
        graph = new int[m + 1][m + 1];

        for (int i = 1; i <= m; i++) {
            graph[sc.nextInt()][sc.nextInt()] = 1;
        }

        check[1] = true;
        dfs(1, graph);

        System.out.println(answer);
    }

    private static void dfs(int node, int[][] graph) {
        if (node == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[node][i] == 1 && !check[i]) {
                    check[i] = true;
                    dfs(i, graph);
                    check[i] = false;
                }
            }
        }
    }
}