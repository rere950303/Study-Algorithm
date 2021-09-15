//
//  Programmers Algorithm 11(디스크 컨트롤러)
//  https://programmers.co.kr/learn/courses/30/lessons/42627
//  Created by hyungwook on 2021/07/04.
//
package com.company;

import java.util.*;

public class Solution {
    public int solution(int[][] jobs) {
        Queue<Task> tasks = new PriorityQueue<>(new ListComparator1());
        Queue<Task> waiting = new PriorityQueue<Task>(new ListComparator2());
        Stack<Task> stack = new Stack<>();
        ArrayList<Integer> answers = new ArrayList<>();
        int time = -1;

        for (int[] job : jobs) {
            tasks.add(new Task(job[0], job[1], 0));
        }

        while (tasks.size() != 0) {
            time++;

            if (stack.size() != 0) {
                Task pop = stack.pop();
                pop.setCounting(pop.getCounting() + 1);
                stack.add(pop);
                while (tasks.size() != 0 && time == tasks.peek().getStartingTime()) {
                    waiting.offer(tasks.poll());
                }
                if (stack.peek().getCounting() == stack.peek().getLoadingTime()) {
                    answers.add(time - stack.peek().getStartingTime());
                    stack.pop();
                    if (waiting.size() != 0) {
                        stack.add(waiting.poll());
                    }
                }
            } else {
                while (tasks.size() != 0 && time == tasks.peek().getStartingTime()) {
                    waiting.offer(tasks.poll());
                }
                if (waiting.size() != 0) {
                    stack.add(waiting.poll());
                }
            }
        }

        while (waiting.size() != 0) {
            time++;

            Task pop = stack.pop();
            pop.setCounting(pop.getCounting() + 1);
            stack.add(pop);

            if (stack.peek().getCounting() == stack.peek().getLoadingTime()) {
                answers.add(time - stack.peek().getStartingTime());
                stack.pop();
                stack.add(waiting.poll());
            }
        }

        if (!stack.empty()) {
            answers.add(time + stack.peek().getLoadingTime() - stack.peek().getCounting() - stack.peek().getStartingTime());
        }

        return (int)answers.stream().mapToInt(i -> i).average().getAsDouble();
    }
}
