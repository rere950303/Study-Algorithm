//
// 규칙찾기(교점에 별 만들기)
// https://programmers.co.kr/learn/courses/30/lessons/87377?language=java
// Created by hyungwook on 2022/02/07.
//

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    long rMax = Long.MIN_VALUE;
    long rMin = Long.MAX_VALUE;
    long cMax = Long.MIN_VALUE;
    long cMin = Long.MAX_VALUE;

    public String[] solution(int[][] line) {
        int length = line.length;
        ArrayList<Point> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                findIntersection(line[i], line[j], list);
            }
        }

        long width = cMax - cMin + 1;
        long vertical = rMax - rMin + 1;

        String[] answer = new String[(int) vertical];
        StringBuilder stringBuilder = new StringBuilder();

        for (long i = 0; i < width; i++) {
            stringBuilder.append('.');
        }
        Arrays.fill(answer, stringBuilder.toString());

        for (Point point : list) {
            long ny = rMax - point.r;
            long nx = point.c - cMin;
            answer[(int) ny] = answer[(int) ny].substring(0, (int) nx) + "*" + answer[(int) ny].substring((int) nx + 1);
        }

        return answer;
    }

    private void findIntersection(int[] a, int[] b, ArrayList<Point> list) {
        long[] tmp = new long[3];

        int i1 = a[0];
        int i2 = b[0];

        for (int i = 0; i < 3; i++) {
            tmp[i] = (long) a[i] * i2 - (long) b[i] * i1;
        }

        double interR = ((double) tmp[2] / (double) tmp[1]) * -1;
        if ((long) interR != interR) {
            return;
        }

        i1 = b[1];
        i2 = a[1];

        for (int i = 0; i < 3; i++) {
            tmp[i] = (long) a[i] * i1 - (long) b[i] * i2;
        }

        double interC = ((double) tmp[2] / (double) tmp[0]) * -1;
        if ((long) interC != interC) {
            return;
        }

        rMax = Math.max(rMax, (long) interR);
        rMin = Math.min(rMin, (long) interR);
        cMax = Math.max(cMax, (long) interC);
        cMin = Math.min(cMin, (long) interC);

        list.add(new Point((long) interR, (long) interC));
    }

    static class Point {
        long r;
        long c;

        public Point(long r, long c) {
            this.r = r;
            this.c = c;
        }
    }
}