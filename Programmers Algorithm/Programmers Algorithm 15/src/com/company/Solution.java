//
//  Programmers Algorithm 15(H-Index)
//  https://programmers.co.kr/learn/courses/30/lessons/42747?language=java#fn1
//  Created by hyungwook on 2021/07/09.
//

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] citations) {
        ArrayList<Integer> collect = Arrays.stream(citations).boxed().collect(Collectors.toCollection(ArrayList::new));
        int length = citations.length;

        Collections.sort(collect, Collections.reverseOrder());

        if (collect.get(0) == 0) {
            return 0;
        }

        for (int i = 1; i <= length; i++) {
            if (collect.get(i - 1) == i) {
                return i;
            } else if (collect.get(i - 1) < i) {
                return i - 1;
            }
        }

        return length;
    }
}
