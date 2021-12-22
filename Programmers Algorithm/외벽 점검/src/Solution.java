//
// 이분 탐색, DFS(외벽 점검)
// https://programmers.co.kr/learn/courses/30/lessons/60062?language=java
// Created by hyungwook on 2021/12/08.
//

public class Solution {

    int[] dist;
    int[] weak;
    int distLen;
    int weakLen;
    int n;
    boolean flag = false;

    public int solution(int n, int[] weak, int[] dist) {
        int answer = -1;
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        this.distLen = dist.length;
        this.weakLen = weak.length;

        int pl = 1;
        int pr = distLen;

        while (pl <= pr) {
            int pc = (pl + pr) / 2;
            int[] worker = getWorker(dist, pc);
            int[] tmp = new int[pc];
            boolean[] check = new boolean[pc];

            canWork(worker, tmp, check, 0);

            if (flag) {
                answer = pc;
                pr = pc - 1;
                flag = false;
            } else {
                pl = pc + 1;
            }
        }

        return answer;
    }

    private void canWork(int[] worker, int[] tmp, boolean[] check, int l) {
        if (flag) {
            return;
        }
        if (l == worker.length) {
            for (int i = 0; i < weakLen; i++) {
                int count = 0;
                int pc = i;
                boolean[] isVisit = new boolean[weakLen];

                for (int work : tmp) {
                    int start = weak[pc % weakLen];
                    while (true) {
                        int interval = weak[pc % weakLen] - start < 0 ? weak[pc % weakLen] - start + n : weak[pc % weakLen] - start;

                        if (interval <= work && !isVisit[pc % weakLen]) {
                            count++;
                            isVisit[pc % weakLen] = true;
                            pc++;
                        } else {
                            break;
                        }
                    }
                }

                if (count == weakLen) {
                    flag = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < worker.length; i++) {
                if (!check[i]) {
                    check[i] = true;
                    tmp[l] = worker[i];
                    canWork(worker, tmp, check, l + 1);
                    check[i] = false;
                }
            }
        }
    }

    private int[] getWorker(int[] dist, int pc) {
        int[] worker = new int[pc];

        for (int i = 0; i < pc; i++) {
            worker[pc - 1 - i] = dist[distLen - 1 - i];
        }

        return worker;
    }
}