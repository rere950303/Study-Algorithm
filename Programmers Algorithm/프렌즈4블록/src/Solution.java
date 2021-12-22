//
// 규칙 찾기(프렌즈4블록)
// https://programmers.co.kr/learn/courses/30/lessons/17679
// Created by hyungwook on 2021/11/25.
//

import java.util.HashSet;
import java.util.Objects;

public class Solution {

    int m;
    int n;

    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        char[][] arr = new char[m][n];
        int answer = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }

        while (true) {
            HashSet<Point> set = new HashSet<>();

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j] != '-' && arr[i][j] == arr[i + 1][j] && arr[i][j] == arr[i + 1][j + 1] && arr[i][j] == arr[i][j + 1]) {
                        set.add(new Point(i, j));
                        set.add(new Point(i + 1, j));
                        set.add(new Point(i + 1, j + 1));
                        set.add(new Point(i, j + 1));
                    }
                }
            }

            if (set.isEmpty()) {
                break;
            }
            remove(set, arr);
            answer += set.size();
        }

        return answer;
    }

    private void remove(HashSet<Point> set, char[][] arr) {
        for (Point point : set) {
            arr[point.r][point.c] = '-';
        }

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i + 1][j] == '-') {
                    while (i >= 0 && arr[i][j] != '-') {
                        char tmp = arr[i][j];
                        arr[i][j] = arr[i + 1][j];
                        arr[i + 1][j] = tmp;
                        i--;
                    }
                }
            }
        }
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

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }
}