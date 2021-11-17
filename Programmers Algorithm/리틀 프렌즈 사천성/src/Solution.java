//
// DFS(리틀 프렌즈 사천성)
// https://programmers.co.kr/learn/courses/30/lessons/1836
// Created by hyungwook on 2021/11/17.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {

    boolean flag = false;
    char target;
    int[][] dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    boolean[][] check;
    int m;
    int n;
    char[][] arr;

    public String solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        String answer = "";
        HashMap<Character, ArrayList<Point>> map = new HashMap<>();
        arr = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
                if (Character.isAlphabetic(arr[i][j])) {
                    if (map.containsKey(arr[i][j])) {
                        ArrayList<Point> list = map.get(arr[i][j]);
                        list.add(new Point(i, j));
                    } else {
                        ArrayList<Point> list = new ArrayList<>();
                        list.add(new Point(i, j));
                        map.put(arr[i][j], list);
                    }
                }
            }
        }

        ArrayList<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int pc = 0;

        while (list.size() > 0) {
            if (pc >= list.size()) {
                return "IMPOSSIBLE";
            }
            Character character = list.get(pc);
            ArrayList<Point> points = map.get(character);
            target = character;
            check = new boolean[m][n];
            check[points.get(0).r][points.get(0).c] = true;
            dfs(points.get(0).r, points.get(0).c, 0, -1);
            if (flag) {
                answer += character;
                arr[points.get(0).r][points.get(0).c] = '.';
                arr[points.get(1).r][points.get(1).c] = '.';
                list.remove(pc);
                pc = 0;
                flag = false;
                continue;
            }
            pc++;
        }

        return answer;
    }

    private void dfs(int r, int c, int l, int changeDir) {
        if (flag) {
            return;
        }
        if (l > 2) {
            return;
        }
        if (arr[r][c] == target && l != 0) {
            flag = true;
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = r + dir[i][0];
                int ny = c + dir[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !check[nx][ny] && (arr[nx][ny] == '.' || arr[nx][ny] == target)) {
                    check[nx][ny] = true;
                    if (i % 2 != changeDir) {
                        dfs(nx, ny, l + 1, i % 2);
                    } else {
                        dfs(nx, ny, l, i % 2);
                    }
                    check[nx][ny] = false;
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
    }
}
