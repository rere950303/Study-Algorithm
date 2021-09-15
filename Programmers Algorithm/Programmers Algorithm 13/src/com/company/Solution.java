//
//  Programmers Algorithm 13(K번째수)
//  https://programmers.co.kr/learn/courses/30/lessons/42748?language=java
//  Created by hyungwook on 2021/07/08.
//
package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> integers = Arrays.stream(array).boxed().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> answer = new ArrayList<>();

        for (int[] command : commands) {
            ArrayList<Integer> clone = (ArrayList<Integer>) integers.clone();
            List<Integer> subList = clone.subList(command[0] - 1, command[1]);
            Collections.sort(subList);
            answer.add(subList.get(command[2] - 1));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
