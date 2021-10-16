//
// 원더랜드(최소스패닝트리)
//
// Created by hyungwook on 2021/10/15.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int v = sc.nextInt();
        int e = sc.nextInt();
        Road[] roads = new Road[e];
        arr = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < e; i++) {
            roads[i] = new Road(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(roads);

        for (int i = 0; i < e; i++) {
            if (find(roads[i].a) != find(roads[i].b)) {
                union(roads[i].a, roads[i].b);
                answer += roads[i].cost;
            }
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int aBoss = find(a);
        int bBoss = find(b);

        if (aBoss != bBoss) {
            arr[aBoss] = bBoss;
        }
    }

    private static int find(int node) {
        if (arr[node] == node) {
            return node;
        } else {
            return arr[node] = find(arr[node]);
        }
    }

    static class Road implements Comparable<Road> {
        int a;
        int b;
        int cost;

        public Road(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }
}