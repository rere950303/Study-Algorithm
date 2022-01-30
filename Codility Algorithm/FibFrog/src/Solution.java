//
// Fibonacci numbers(FibFrog)
// https://app.codility.com/programmers/lessons/13-fibonacci_numbers/fib_frog/
// Created by hyungwook on 2022/01/26.
//

import java.util.LinkedList;

public class Solution {
    int[] fibonacci = new int[100000];

    public int solution(int[] A) {
        int length = A.length;
        int arrival = length + 1;
        boolean[] check = new boolean[length];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        int pc = 2;

        while (fibonacci[pc - 1] <= arrival) {
            fibonacci[pc] = getFibonacci(pc);
            pc++;
        }
        pc -= 2;
        LinkedList<Point> queue = new LinkedList<>();

        queue.add(new Point(-1, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = pc; i >= 0; i--) {
                int tmp = point.idx + fibonacci[i];
                if (tmp < 0 || tmp > length) {
                    continue;
                }
                if (tmp == length) {
                    return point.time + 1;
                } else {
                    if (A[tmp] == 1 && !check[tmp]) {
                        check[tmp] = true;
                        queue.add(new Point(tmp, point.time + 1));
                    }
                }
            }
        }

        return -1;
    }

    private int getFibonacci(int pc) {
        if (pc == 0) {
            return 0;
        }
        if (pc == 1) {
            return 1;
        }
        if (fibonacci[pc] != 0) {
            return fibonacci[pc];
        }

        return fibonacci[pc - 1] + fibonacci[pc - 2];
    }

    static class Point {
        int idx;
        int time;

        public Point(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
}