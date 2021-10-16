//
// 최대 수입 스케쥴(PriorityQueue 응용문제)
//
// Created by hyungwook on 2021/10/13.
//

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int madD = 0;
        int answer = 0;
        int pc = 0;
        Lecture[] lectures = new Lecture[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            lectures[i] = new Lecture(m, d);
            madD = Math.max(madD, d);
        }

        Arrays.sort(lectures);

        for (int i = madD; i >= 1; i--) {
            while (pc < n && lectures[pc].d == i) {
                queue.add(lectures[pc++].m);
            }
            if (!queue.isEmpty()) {
                answer += queue.poll();
            }
        }

        System.out.println(answer);
    }

    static class Lecture implements Comparable<Lecture>{
        int m;
        int d;

        public Lecture(int m, int d) {
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.d - this.d;
        }
    }
}