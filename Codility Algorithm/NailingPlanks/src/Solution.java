//
// Binary search algorithm(NailingPlanks)
// https://app.codility.com/programmers/lessons/14-binary_search_algorithm/nailing_planks/
// Created by hyungwook on 2022/01/27.
//

import java.util.*;

public class Solution {

    public int solution(int[] A, int[] B, int[] C) {
        int pl = 1;
        int pr = C.length;
        int answer = -1;
        int length = A.length;
        ArrayList<Point> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            list.add(new Point(A[i], B[i]));
        }

        Collections.sort(list);

        while (pl <= pr) {
            int pc = (pl + pr) / 2;

            if (canNail(list, Arrays.copyOf(C, pc))) {
                answer = pc;
                pr = pc - 1;
            } else {
                pl = pc + 1;
            }
        }

        return answer;
    }

    private boolean canNail(ArrayList<Point> list, int[] C) {
        int length = C.length;
        Arrays.sort(C);
        int c = 0;
        int idx = 0;
        int size = list.size();

        while (c < length && idx < size) {
            Point point = list.get(idx);

            if (C[c] >= point.start && C[c] <= point.end) {
                idx++;
                continue;
            } else {
                c++;
            }
        }

        return idx == size;
    }

    static class Point implements Comparable<Point> {
        int start;
        int end;

        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Point o) {
            return this.start - o.start;
        }
    }
}