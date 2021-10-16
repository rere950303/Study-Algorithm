//
// 미로탐색(DFS)
//
// Created by hyungwook on 2021/10/11.
//

import java.util.Scanner;

public class Solution {

    static int[][] arr;
    static int answer = 0;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[9][9];

        for (int i = 0; i <= 8; i++) {
            arr[0][i] = arr[i][0] = 1;
            arr[8][i] = arr[i][8] = 1;
        }

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(1, 1);

        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        if (x == 7 && y == 7) {
            answer++;
        } else {
            for (int i = 0; i < 4; i++) {
                if (arr[x + dir[i][0]][y + dir[i][1]] == 0) {
                    arr[x][y] = 1;
                    dfs(x + dir[i][0], y + dir[i][1]);
                    arr[x][y] = 0;
                }
            }
        }
    }
}