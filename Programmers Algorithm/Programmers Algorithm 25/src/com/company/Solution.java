//
//  Programmers Algorithm 25(N으로 표현)
//  https://programmers.co.kr/learn/courses/30/lessons/42895
//  Created by hyungwook on 2021/07/23.
//

package com.company;

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution {

    ArrayList<TreeSet<Integer>> list = new ArrayList<>();
    int temp;

    public int solution(int N, int number) {

        temp = N;

        for (int i = 0; i < 8; i++) {
            addNum(temp, i);
            temp = temp * 10 + N;
        }

        for (int i = 0; i < 8; i++) {
            TreeSet<Integer> treeSet = list.get(i);
            boolean isContain = treeSet.contains(number);
            if (isContain == true) {
                return i + 1;
            }
        }

        return -1;
    }

    public void addNum(int temp, int i) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(temp);

        for (int j = 0; j < i; j++) {
            TreeSet<Integer> treeSet1 = list.get(j);
            TreeSet<Integer> treeSet2 = list.get(i - 1 - j);

            for (Integer integer1 : treeSet1) {
                for (Integer integer2 : treeSet2) {
                    treeSet.add(integer1 + integer2);
                    treeSet.add(integer1 - integer2);
                    treeSet.add(integer1 * integer2);
                    if (integer2 != 0) {
                        treeSet.add(integer1 / integer2);
                    }
                }
            }
        }

        list.add(treeSet);
    }
}