//
//  Programmers Algorithm 12(이중우선순위큐)
//  https://programmers.co.kr/learn/courses/30/lessons/42628
//  Created by hyungwook on 2021/07/06.
//
package com.company;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> priorityQueue_up = new PriorityQueue<>();
        Queue<Integer> priorityQueue_down = new PriorityQueue<>(Collections.reverseOrder());
        int flag = -1;
        int[] answer = new int[2];

        for (String operation : operations) {
            char c = operation.charAt(0);

            if (c == 'I') {
                int parseInt = Integer.parseInt(operation.replaceAll("[^0-9]", ""));

                if (operation.charAt(2) == '-') {
                    parseInt *= -1;
                }
                if (flag == -1) {
                    priorityQueue_up.offer(parseInt);
                } else {
                    priorityQueue_down.offer(parseInt);
                }
            }
            else {
                if (priorityQueue_up.size() == 0 && priorityQueue_down.size() == 0) {
                    continue;
                }

                if (operation.charAt(2) == '-') {
                    if (flag == -1) {
                        priorityQueue_up.poll();
                    } else {
                        priorityQueue_up.clear();
                        for (Integer integer : priorityQueue_down) {
                            priorityQueue_up.offer(integer);
                        }
                        priorityQueue_up.poll();
                        flag = -1;
                    }
                } else {
                    if (flag == 1) {
                        priorityQueue_down.poll();
                    } else {
                        priorityQueue_down.clear();
                        for (Integer integer : priorityQueue_up) {
                            priorityQueue_down.offer(integer);
                        }
                        priorityQueue_down.poll();
                        flag = 1;
                    }
                }
            }
        }

        if (flag == 1) {
            if (priorityQueue_down.size() == 0) {
                answer[0] = answer[1] = 0;
            } else if (priorityQueue_down.size() == 1) {
                answer[0] = priorityQueue_down.poll();
                answer[1] = 0;
            } else {
                answer[0] = priorityQueue_down.peek();
                priorityQueue_up.clear();
                for (Integer integer : priorityQueue_down) {
                    priorityQueue_up.offer(integer);
                }
                answer[1] = priorityQueue_up.peek();
            }
        } else {
            if (priorityQueue_up.size() == 0) {
                answer[0] = answer[1] = 0;
            } else if (priorityQueue_up.size() == 1) {
                answer[1] = priorityQueue_up.poll();
                answer[0] = 0;
            } else {
                answer[1] = priorityQueue_up.peek();
                priorityQueue_down.clear();
                for (Integer integer : priorityQueue_up) {
                    priorityQueue_down.offer(integer);
                }
                answer[0] = priorityQueue_down.peek();
            }
        }

        return answer;
    }
}
