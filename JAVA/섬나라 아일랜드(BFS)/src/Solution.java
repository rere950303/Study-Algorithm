//
// 섬나라 아일랜드(BFS)
//
// Created by hyungwook on 2021/10/11.
//

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static int[][] arr;
    static int[][] dir = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static Queue<Point> queue = new LinkedList<>();

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
                    queue.add(new Point(i, j));
                    answer++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int row, int column) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point poll = queue.poll();
                for (int j = 0; j < 8; j++) {
                    if (arr[poll.row + dir[j][0]][poll.column + dir[j][1]] == 1) {
                        arr[poll.row + dir[j][0]][poll.column + dir[j][1]] = 0;
                        queue.add(new Point(poll.row + dir[j][0], poll.column + dir[j][1]));
                    }
                }
            }
        }
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