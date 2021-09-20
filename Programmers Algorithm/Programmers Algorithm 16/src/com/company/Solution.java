//
//  Programmers Algorithm 16(모의고사)
//  https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
//  Created by hyungwook on 2021/07/10.
//

package com.company;

import java.util.*;

public class Solution {
    public int[] solution(int[] answers) {

        TreeMap<Integer, ArrayList<Integer>> answer = new TreeMap<>();
        int[] giveUp1 = {1, 2, 3, 4, 5};
        int[] giveUp2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] giveUp3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int length = answers.length;

        countingCorrect(answers, answer, giveUp1, length, 1);
        countingCorrect(answers, answer, giveUp2, length, 2);
        countingCorrect(answers, answer, giveUp3, length, 3);

        return answer.pollLastEntry().getValue().stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private void countingCorrect(int[] answers, TreeMap<Integer, ArrayList<Integer>> answer, int[] giveUp1, int length, int person) {
        ArrayList<Integer> list = answer.getOrDefault(getCount(answers, giveUp1, length, giveUp1.length), new ArrayList<Integer>());
        list.add(person);
        answer.put(getCount(answers, giveUp1, length, giveUp1.length), list);
    }

    private int getCount(int[] answers, int[] giveUp, int length, int giveUpLength) {
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (answers[i] == giveUp[i % giveUpLength]) {
                count++;
            }
        }

        return count;
    }
}
