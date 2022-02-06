//
// BFS(게임 맵 최단거리)
// https://programmers.co.kr/learn/courses/30/lessons/1844
// Created by hyungwook on 2022/02/03.
//

import java.util.LinkedList;

public class Solution {

    public int solution(int[][] maps) {
        int r = maps.length;
        int c = maps[0].length;
        LinkedList<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        maps[0][0] = 0;
        int l = 1;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point poll = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int rx = poll.r + dir[j][0];
                    int cx = poll.c + dir[j][1];

                    if (rx == r - 1 && cx == c - 1) {
                        return l + 1;
                    }

                    if (rx >= 0 && rx < r && cx >= 0 && cx < c && maps[rx][cx] == 1) {
                        maps[rx][cx] = 0;
                        queue.add(new Point(rx, cx));
                    }
                }
            }

            l++;
        }

        return -1;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}