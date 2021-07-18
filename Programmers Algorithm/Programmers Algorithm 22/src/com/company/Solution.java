//
//  Programmers Algorithm 22(구명보트)
//  https://programmers.co.kr/learn/courses/30/lessons/42885?language=java
//  Created by hyungwook on 2021/07/18.
//
package com.company;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] integers = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, Collections.reverseOrder());
        int pl = 0;
        int pr = people.length - 1;

        while (pl < pr) {
            if (integers[pl] + integers[pr] <= limit) {
                answer++;
                pl++;
                pr--;
                continue;
            }
            answer++;
            pl++;
        }

        if (pl == pr) {
            answer++;
        }

        return answer;
    }
}
