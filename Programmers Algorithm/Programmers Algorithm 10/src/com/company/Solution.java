//
//  Programmers Algorithm 10(더 맵게)
//  https://programmers.co.kr/learn/courses/30/lessons/42626/solution_groups?language=java&type=my
//  Created by hyungwook on 2021/07/03.
//

package com.company;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Stream<Integer> stream = IntStream.of(scoville).filter(i -> i < K).boxed();
        Queue<Integer> priorityQueue = stream.collect(Collectors.toCollection(PriorityQueue::new));

        while (true) {
            answer++;

            priorityQueue.offer(priorityQueue.poll() + priorityQueue.poll() * 2);

            if (priorityQueue.size() == 1 && priorityQueue.peek() < K) {
                return -1;
            }
            else if (priorityQueue.peek() >= K) {
                return answer;
            }
        }
    }
}
