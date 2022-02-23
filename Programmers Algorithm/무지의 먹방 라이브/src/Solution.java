//
// 우선순위큐(무지의 먹방 라이브)
// https://programmers.co.kr/learn/courses/30/lessons/42891
// Created by hyungwook on 2022/02/22.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

    public int solution(int[] food_times, long k) {
        int length = food_times.length;
        long sum = 0;
        PriorityQueue<Point> queue = new PriorityQueue<>((p1, p2) -> p1.v - p2.v);

        for (int i = 0; i < length; i++) {
            sum += food_times[i];
            queue.add(new Point(food_times[i], i + 1));
        }

        if (sum <= k) {
            return -1;
        }

        int previous = 0;

        while (!queue.isEmpty()) {
            Point point = queue.peek();
            long discount = k - ((long) point.v - previous) * queue.size();

            if (discount <= 0) {
                break;
            }

            queue.poll();
            k = discount;
            previous = point.v;
        }

        ArrayList<Point> list = new ArrayList<>(queue);
        Collections.sort(list, (p1, p2) -> p1.idx - p2.idx);

        return list.size() == 0 ? -1 : list.get((int) (k % list.size())).idx;
    }

    static class Point {
        int v;
        int idx;

        public Point(int v, int idx) {
            this.v = v;
            this.idx = idx;
        }
    }
}