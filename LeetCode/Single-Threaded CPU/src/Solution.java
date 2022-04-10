//
// Priority Queue, Sorting(Single-Threaded CPU)
// https://leetcode.com/problems/single-threaded-cpu/
// Created by hyungwook on 2022/04/10.
//

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public int[] getOrder(int[][] tasks) {
        int[] answer = new int[tasks.length];
        int[][] indexed_tasks = new int[tasks.length][3];

        for (int i = 0; i < tasks.length; i++) {
            indexed_tasks[i][0] = i;
            indexed_tasks[i][1] = tasks[i][0];
            indexed_tasks[i][2] = tasks[i][1];
        }
        Arrays.sort(indexed_tasks, (i1, i2) -> Integer.compare(i1[1], i2[1]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] != o2[2]) {
                    return Integer.compare(o1[2], o2[2]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });

        int firstEnqueueTime = indexed_tasks[0][1];
        int idx = 0;

        for (int[] task : indexed_tasks) {
            if (task[1] != firstEnqueueTime) {
                break;
            }
            queue.add(new int[]{task[0], task[1], task[2]});
            idx++;
        }

        int answerIdx = 0;
        int limitTime = indexed_tasks[0][1];

        while (answerIdx < answer.length) {
            int[] poll = queue.poll();
            answer[answerIdx++] = poll[0];
            limitTime += poll[2];
            boolean flag = false;

            for (; idx < tasks.length; idx++) {
                if (indexed_tasks[idx][1] <= limitTime) {
                    flag = true;
                    queue.add(new int[]{indexed_tasks[idx][0], indexed_tasks[idx][1], indexed_tasks[idx][2]});
                } else {
                    break;
                }
            }
            if (!flag && idx < indexed_tasks.length && queue.isEmpty()) {
                int enqueueTime = indexed_tasks[idx][1];

                for (; idx < tasks.length; idx++) {
                    if (indexed_tasks[idx][1] == enqueueTime) {
                        queue.add(new int[]{indexed_tasks[idx][0], indexed_tasks[idx][1], indexed_tasks[idx][2]});
                    } else {
                        break;
                    }
                }
                limitTime = enqueueTime;
            }
        }

        return answer;
    }
}