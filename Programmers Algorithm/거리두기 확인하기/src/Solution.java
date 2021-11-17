//
// BFS(거리두기 확인하기)
// https://programmers.co.kr/learn/courses/30/lessons/81302?language=java#fn1
// Created by hyungwook on 2021/11/15.
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int pc = 0;

        for (String[] place : places) {
            char[][] arr = toCharArr(place);
            answer[pc++] = bfs(arr);
        }

        return answer;
    }

    private int bfs(char[][] arr) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == 'P') {
                    Queue<Point> queue = new LinkedList<>();
                    int l = 1;
                    queue.add(new Point(i, j));
                    arr[i][j] = 'X';
                    while (!queue.isEmpty() && l <= 2) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            Point poll = queue.poll();
                            for (int p = 0; p < 4; p++) {
                                int nr = poll.r + dir[p][0];
                                int nc = poll.c + dir[p][1];
                                if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && arr[nr][nc] != 'X') {
                                    if (arr[nr][nc] == 'P') {
                                        return 0;
                                    }
                                    queue.add(new Point(nr, nc));
                                }
                            }
                        }
                        l++;
                    }
                }
            }
        }
        return 1;
    }

    private char[][] toCharArr(String[] place) {
        char[][] arr = new char[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = place[i].charAt(j);
            }
        }
        return arr;
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