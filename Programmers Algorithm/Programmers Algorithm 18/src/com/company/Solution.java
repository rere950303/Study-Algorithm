//
//  Programmers Algorithm 18(카펫)
//  https://programmers.co.kr/learn/courses/30/lessons/42842
//  Created by hyungwook on 2021/07/12.
//
package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public int[] solution(int brown, int yellow) {

        int[] answer = new int[2];
        ArrayList<Combination> combinations = new ArrayList<>();

        for (int i = 1; i * i <= yellow; i++) {
            if (yellow % i == 0) {
                combinations.add(new Combination(i, yellow / i, 2 * (i + 2) + 2 * (yellow / i + 2) - 4));
            }
        }

        Collections.sort(combinations, new Comparator<Combination>() {
            @Override
            public int compare(Combination o1, Combination o2) {
                int brownNum1 = o1.getBrownNum();
                int brownNum2 = o2.getBrownNum();

                return brownNum1 - brownNum2;
            }
        });

        int search = Collections.binarySearch(combinations, new Combination(0, 0, brown), new Comparator<Combination>() {
            @Override
            public int compare(Combination o1, Combination o2) {
                int brownNum1 = o1.getBrownNum();
                int brownNum2 = o2.getBrownNum();

                return brownNum1 - brownNum2;
            }
        });

        answer[0] = combinations.get(search).getLength() + 2;
        answer[1] = combinations.get(search).getTransverse() + 2;

        return answer;
    }
}
