//
// 규칙 찾기(기둥과 보 설치)
// https://programmers.co.kr/learn/courses/30/lessons/60061
// Created by hyungwook on 2021/11/30.
//

public class Solution {

    boolean[][] pillar;
    boolean[][] beam;
    int n;

    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        this.pillar = new boolean[n + 1][n + 1];
        this.beam = new boolean[n + 1][n + 1];
        int count = 0;

        for (int[] ints : build_frame) {
            int r = ints[0];
            int c = ints[1];
            int k = ints[2];
            int t = ints[3];

            if (t == 1) {
                if (k == 0) {
                    if (isPossiblePillar(r, c)) {
                        pillar[r][c] = true;
                        count++;
                    }
                } else {
                    if (isPossibleBeam(r, c)) {
                        beam[r][c] = true;
                        count++;
                    }
                }
            } else {
                if (k == 0) {
                    pillar[r][c] = false;
                    count--;
                    if (!isPossibleDelete()) {
                        pillar[r][c] = true;
                        count++;
                    }
                } else {
                    beam[r][c] = false;
                    count--;
                    if (!isPossibleDelete()) {
                        beam[r][c] = true;
                        count++;
                    }
                }
            }
        }

        int[][] answer = new int[count][3];
        int idx = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillar[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = 0;
                    idx++;
                }
                if (beam[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx][2] = 1;
                    idx++;
                }
            }
        }

        return answer;
    }

    private boolean isPossibleDelete() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillar[i][j] && !isPossiblePillar(i, j)) {
                    return false;
                }
                if (beam[i][j] && !isPossibleBeam(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isPossiblePillar(int r, int c) {
        if (c == 0) {
            return true;
        } else if (pillar[r][c - 1]) {
            return true;
        } else if (beam[r][c]) {
            return true;
        } else if (r > 0 && beam[r - 1][c]) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPossibleBeam(int r, int c) {
        if (pillar[r][c - 1] || pillar[r + 1][c - 1]) {
            return true;
        } else if (r > 0 && beam[r - 1][c] && beam[r + 1][c]) {
            return true;
        } else {
            return false;
        }
    }
}