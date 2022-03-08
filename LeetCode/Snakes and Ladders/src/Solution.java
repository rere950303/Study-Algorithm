//
// BFS, Matrix(Snakes and Ladders)
// https://leetcode.com/problems/snakes-and-ladders/
// Created by hyungwook on 2022/03/06.
//

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int n;
    int[][] board;

    public int snakesAndLadders(int[][] board) {
        this.board = board;
        this.n = board.length;
        int target = n * n;
        boolean[] isVisit = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        int l = 0;
        isVisit[1] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                int start = poll + 1;
                int end = Math.min(poll + 6, target);

                for (int j = start; j <= end; j++) {
                    int next = getNext(j);

                    if (next == target) {
                        return l + 1;
                    }
                    if (!isVisit[next]) {
                        isVisit[next] = true;
                        queue.add(next);
                    }
                }
            }

            l++;
        }

        return -1;
    }

    private int getNext(int next) {
        int sub = next - 1;
        int r = n - 1 - (sub / n);
        int c = (n - 1 - r) % 2 == 0 ? sub % n : n - 1 - (sub % n);

        return board[r][c] != -1 ? board[r][c] : next;
    }
}