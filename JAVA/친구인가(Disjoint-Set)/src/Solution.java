//
// 친구인가(Disjoint-Set)
//
// Created by hyungwook on 2021/10/14.
//

import java.util.Scanner;

public class Solution {

    static int[] boss;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boss = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            boss[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }

        if (find(sc.nextInt()) != find(sc.nextInt())) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    private static void union(int a, int b) {
        int finalBossOfA = find(a);
        int finalBossOfB = find(b);
        if (finalBossOfA != finalBossOfB) {
            boss[finalBossOfA] = finalBossOfB;
        }
    }

    private static int find(int person) {
        if (boss[person] == person) {
            return boss[person];
        } else {
            return boss[person] = find(boss[person]);
        }
    }
}