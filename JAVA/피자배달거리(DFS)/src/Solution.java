//
// 피자배달거리(DFS)
//
// Created by hyungwook on 2021/10/12.
//

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> pizza = new ArrayList<>();
    static Point[] tmp;
    static int m;
    static int pizzaCount = 0;
    static int houseCount = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n + 1][n + 1];
        tmp = new Point[m];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    house.add(new Point(i, j));
                    houseCount++;
                }
                if (arr[i][j] == 2) {
                    pizza.add(new Point(i, j));
                    pizzaCount++;
                }
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    private static void dfs(int L, int start) {
        if (L == m) {
            answer = Math.min(answer, minLen());
        } else {
            for (int i = start; i < pizzaCount; i++) {
                tmp[L] = pizza.get(i);
                dfs(L + 1, i + 1);

            }
        }
    }

    private static int minLen() {
        int sum = 0;

        for (int i = 0; i < houseCount; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                temp = Math.min(temp, Math.abs(tmp[j].row - house.get(i).row) + Math.abs(tmp[j].column - house.get(i).column));
            }
            sum += temp;
        }

        return sum;
    }

    static class Point {
        int row;
        int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}