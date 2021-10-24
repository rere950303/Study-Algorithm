//
// BFS(아이템 줍기)
// https://programmers.co.kr/learn/courses/30/lessons/87694?language=java
// Created by hyungwook on 2021/10/21.
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] arr = new int[103][103];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Point> queue = new LinkedList<>();
        int answer = 1;
        Point target = new Point(itemX * 2, itemY * 2);

        for (int[] ints : rectangle) {
            for (int i = ints[0] * 2; i <= ints[2] * 2; i++) {
                for (int j = ints[1] * 2; j <= ints[3] * 2; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        for (int[] ints : rectangle) {
            for (int i = ints[0] * 2 + 1; i < ints[2] * 2; i++) {
                for (int j = ints[1] * 2 + 1; j < ints[3] * 2; j++) {
                    arr[i][j] = 0;
                }
            }
        }

        arr[characterX * 2][characterY * 2] = 0;
        queue.add(new Point(characterX * 2, characterY * 2));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point poll = queue.poll();

                for (int j = 0; j < 4; j++) {
                    if (arr[poll.r + dir[j][0]][poll.c + dir[j][1]] != 0) {
                        arr[poll.r + dir[j][0]][poll.c + dir[j][1]] = 0;
                        queue.add(new Point(poll.r + dir[j][0], poll.c + dir[j][1]));
                    }
                }
            }

            if (queue.contains(target)) {
                break;
            }

            answer++;
        }

        return answer / 2;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return r == point.r && c == point.c;
        }
    }
}