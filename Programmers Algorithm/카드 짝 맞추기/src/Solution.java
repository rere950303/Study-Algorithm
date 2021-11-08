//
// dfs, bfs(카드 짝 맞추기)
// https://programmers.co.kr/learn/courses/30/lessons/72415
// Created by hyungwook on 2021/11/08.
//

import java.util.*;

public class Solution {

    ArrayList<ArrayList<Point>> list = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    int answer = Integer.MAX_VALUE;
    int r;
    int c;
    int min = Integer.MAX_VALUE;
    int[][] board = new int[4][4];
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int[][] board, int r, int c) {
        this.r = r;
        this.c = c;
        for (int i = 0; i <= 6; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    list.get(board[i][j]).add(new Point(i, j));
                    set.add(board[i][j]);
                }
            }
        }

        int[] arr = set.stream().mapToInt(i -> i).toArray();
        int length = arr.length;
        boolean[] check = new boolean[length];
        int[] tmp = new int[length];

        dfs(tmp, check, arr, length, 0, board);

        return answer;
    }

    private void dfs(int[] tmp, boolean[] check, int[] arr, int length, int l, int[][] board) {
        if (l == length) {
            min = Integer.MAX_VALUE;
            int[] permutation = new int[length * 2];
            imageOrder(permutation, tmp, length, 0, board);
            answer = Math.min(min, answer);
        } else {
            for (int i = 0; i < length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    tmp[l] = arr[i];
                    dfs(tmp, check, arr, length, l + 1, board);
                    check[i] = false;
                }
            }
        }
    }

    private void imageOrder(int[] permutation, int[] tmp, int length, int l, int[][] board) {
        if (l == length) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    this.board[i][j] = board[i][j];
                }
            }
            min = Math.min(min, removeOrder(permutation, tmp));
        } else {
            permutation[l * 2] = 0;
            permutation[l * 2 + 1] = 1;
            imageOrder(permutation, tmp, length, l + 1, board);
            permutation[l * 2] = 1;
            permutation[l * 2 + 1] = 0;
            imageOrder(permutation, tmp, length, l + 1, board);
        }
    }

    private int removeOrder(int[] permutation, int[] tmp) {
        int sum = 0;
        int length = permutation.length;
        int r = this.r;
        int c = this.c;

        for (int i = 0; i < length - 1; i += 2) {
            ArrayList<Point> points = list.get(tmp[i / 2]);
            for (int j = 0; j < 2; j++) {
                Point point = points.get(permutation[i + j]);
                sum += (bfs(new Point(r, c), point) + 1);
                r = point.r;
                c = point.c;
            }
            board[points.get(0).r][points.get(0).c] = board[points.get(1).r][points.get(1).c] = 0;
        }

        return sum;
    }

    private int bfs(Point start, Point end) {
        int[][] check = new int[4][4];
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        check[start.r][start.c] = 1;
        int l = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Point poll = queue.poll();
                int r = poll.r;
                int c = poll.c;

                if (r == end.r && c == end.c) {
                    return l;
                }
                for (int j = 0; j < 4; j++) {
                    r = poll.r;
                    c = poll.c;
                    if (r + dir[j][0] >= 0 && r + dir[j][0] < 4 && c + dir[j][1] < 4 && c + dir[j][1] >= 0) {
                        if (check[r + dir[j][0]][c + dir[j][1]] == 0) {
                            check[r + dir[j][0]][c + dir[j][1]] = 1;
                            queue.add(new Point(r + dir[j][0], c + dir[j][1]));
                        }
                    }

                    while (r + dir[j][0] >= 0 && r + dir[j][0] < 4 && c + dir[j][1] < 4 && c + dir[j][1] >= 0) {
                        r += dir[j][0];
                        c += dir[j][1];
                        if (board[r][c] != 0) {
                            break;
                        }
                    }

                    if (check[r][c] == 0) {
                        check[r][c] = 1;
                        queue.add(new Point(r, c));
                    }
                }
            }
            l++;
        }

        return l;
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