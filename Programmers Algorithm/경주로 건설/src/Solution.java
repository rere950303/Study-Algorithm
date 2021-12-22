//
// BFS(경주로 건설)
// https://programmers.co.kr/learn/courses/30/lessons/67259
// Created by hyungwook on 2021/11/27.
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int[][] board) {
        int[][] dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int length = board.length;
        int answer = Integer.MAX_VALUE;

        boolean[][][] isVisit = new boolean[length][length][4];

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0, 0, -1));
        isVisit[0][0][0] = isVisit[0][0][1] = isVisit[0][0][2] = isVisit[0][0][3] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point poll = queue.poll();
                if (poll.r == length - 1 && poll.c == length - 1) {
                    answer = Math.min(answer, poll.cost);
                }

                for (int j = 0; j < 4; j++) {
                    int rn = poll.r + dir[j][0];
                    int cn = poll.c + dir[j][1];

                    if (rn >= 0 && rn < length && cn >= 0 && cn < length && board[rn][cn] != 1) {
                        int cost = poll.dir == -1 || poll.dir == j ? poll.cost + 100 : poll.cost + 600;

                        if (!isVisit[rn][cn][j] || board[rn][cn] >= cost) {
                            isVisit[rn][cn][j] = true;
                            board[rn][cn] = cost;
                            queue.add(new Point(rn, cn, cost, j));
                        }
                    }
                }
            }
        }

        return answer;
    }

    static class Point {
        int r;
        int c;
        int cost;
        int dir;

        public Point(int r, int c, int cost, int dir) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.dir = dir;
        }
    }
}