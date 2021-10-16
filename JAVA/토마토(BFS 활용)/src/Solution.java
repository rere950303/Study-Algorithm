//
// 토마토(BFS 활용)
//
// Created by hyungwook on 2021/10/11.
//

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static int[][] arr;
    static Queue<Point> queue = new LinkedList<>();
    static int zeroCount = 0;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[m + 2][n + 2];

        for (int i = 0; i < m + 2; i++) {
            arr[i][0] = arr[i][n + 1] = 1;
        }

        for (int i = 0; i < n + 2; i++) {
            arr[0][i] = arr[m + 1][i] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
                if (arr[i][j] == 0) {
                    zeroCount++;
                }
            }
        }

        int answer = bfs();

        if (zeroCount == 0) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    private static int bfs() {
        int L = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    if (arr[poll.row + dir[j][0]][poll.column + dir[j][1]] == 0) {
                        zeroCount--;
                        arr[poll.row + dir[j][0]][poll.column + dir[j][1]] = 1;
                        queue.add(new Point(poll.row + dir[j][0], poll.column + dir[j][1]));
                    }
                }
            }
            L++;
        }

        return L;
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