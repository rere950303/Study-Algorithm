//
//  Programmers Algorithm 6(기능개발)
//  https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
//  Created by hyungwook on 2021/06/30.
//
package com.company;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> days = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        int length = progresses.length;

        for(int i = 0; i < length; i++)
        {
            double res = (100.0 - progresses[i]) % speeds[i];

            if (res == 0)
            {
                days.add((100 - progresses[i]) / speeds[i]);
            }
            else
            {
                days.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        int pc = 0;

        while(pc < length)
        {
            int pr = pc;
            pc++;
            int count = 1;

            while(pc < length && days.get(pr) >= days.get(pc))
            {
                count++;
                pc++;
            }
            answer.add(count);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
