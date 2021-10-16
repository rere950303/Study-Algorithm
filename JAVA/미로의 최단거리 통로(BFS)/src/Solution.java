//
// 미로의 최단거리 통로(BFS)
//
// Created by hyungwook on 2021/10/11.
//

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    static int[][] arr = new int[9][9];
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int answer = -1;
    static Queue<Coordinate> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            arr[i][0] = arr[0][i] = 1;
            arr[8][i] = arr[i][8] = 1;
        }

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        queue.add(new Coordinate(1, 1));
        arr[1][1] = 1;
        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        int L = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Coordinate poll = queue.poll();
                arr[poll.row][poll.column] = 1;
                for (int j = 0; j < 4; j++) {
                    if (arr[poll.row + dir[j][0]][poll.column + dir[j][1]] == 0) {
                        queue.add(new Coordinate(poll.row + dir[j][0], poll.column + dir[j][1]));
                    }
                }
            }

            if (queue.contains(new Coordinate(7, 7))) {
                answer = L;
                break;
            }

            L++;
        }
    }

    static class Coordinate {
        int row;
        int column;

        public Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row && column == that.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }
}