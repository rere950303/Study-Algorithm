//
// 경로 탐색(인접리스트)
//
// Created by hyungwook on 2021/10/06.
//

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static boolean check[];
    static int answer = 0;
    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        check = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            graph.get(sc.nextInt()).add(sc.nextInt());
        }

        check[1] = true;
        dfs(1);

        System.out.println(answer);
    }

    private static void dfs(int node) {
        if (node == n) {
            answer++;
        } else {
            for (Integer integer : graph.get(node)) {
                if (!check[integer]) {
                    check[integer] = true;
                    dfs(integer);
                    check[integer] = false;
                }
            }
        }
    }
}