//
// 섬나라 아일랜드(DFS)
//
// Created by hyungwook on 2021/10/11.
//

import java.util.Scanner;

public class Solution {

    static int[][] arr;
    static int[][] dir = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        arr = new int[n + 2][n + 2];

        for (int i = 0; i < n + 2; i++) {
            arr[i][0] = arr[0][i] = 0;
            arr[n + 1][i] = arr[i][n + 1] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    answer++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int row, int column) {
        for (int i = 0; i < 8; i++) {
            if (arr[row + dir[i][0]][column + dir[i][1]] == 1) {
                arr[row + dir[i][0]][column + dir[i][1]] = 0;
                dfs(row + dir[i][0], column + dir[i][1]);
            }
        }
    }
}