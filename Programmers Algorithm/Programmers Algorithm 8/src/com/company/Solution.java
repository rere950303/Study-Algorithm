//
//  Programmers Algorithm 8(다리를 지나는 트럭)
//  https://programmers.co.kr/learn/courses/30/lessons/42583
//  Created by hyungwook on 2021/07/03.
//
package com.company;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int weight_bridge = 0;
        int length = truck_weights.length;

        Queue<Truck> passing = new LinkedList<>();
        Queue<Truck> waiting = new LinkedList<>();

        for(int i = 0; i < length; i++)
        {
            waiting.offer(new Truck(truck_weights[i], 0));
        }

        while (true) {
            answer++;

            if(passing.size() != 0)
            {
                for (Truck truck : passing)
                {
                    truck.setTime(truck.getTime() + 1);
                }
                if (passing.peek().getTime() == bridge_length)
                {
                    weight_bridge -= passing.peek().getWeight();
                    passing.poll();
                }
            }

            if(passing.size() == 0 && waiting.size() == 0)
            {
                break;
            }

            if(waiting.size() != 0)
            {
                if(waiting.peek().getWeight() + weight_bridge <= weight)
                {
                    weight_bridge += waiting.peek().getWeight();
                    passing.offer(waiting.poll());
                }
            }
        }

        return answer;
    }
}
