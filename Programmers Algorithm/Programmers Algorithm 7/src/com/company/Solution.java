//
//  Programmers Algorithm 7(프린터)
//  https://programmers.co.kr/learn/courses/30/lessons/42587?language=java
//  Created by hyungwook on 2021/07/01.
//
package com.company;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] priorities, int location) {
        List<Integer> intList1 = Arrays.stream(priorities).boxed().collect(Collectors.toList());
        Queue<Entry> entries = new LinkedList<>();
        int length = priorities.length;

        for(int i = 0; i < length; i++)
        {
            Entry entry = new Entry(i, priorities[i]);
            entries.offer(entry);
        }

        intList1.sort(Collections.reverseOrder());

        int pc = 0;
        int answer = 0;

        while (true) {
            if(entries.peek().getValue() >= intList1.get(pc))
            {
                int priority = entries.peek().getKey();
                entries.poll();
                answer++;
                pc++;
                if (priority == location)
                {
                    return answer;
                }
            }
            else
            {
                Entry entry = entries.poll();
                entries.offer(entry);
            }
        }
    }
}
