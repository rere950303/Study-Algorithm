//
//  Programmers Algorithm 24(단속카메라)
//  https://programmers.co.kr/learn/courses/30/lessons/42884
//  Created by hyungwook on 2021/07/21.
//

package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int solution(int[][] routes) {
        int[] temp = new int[4];
        int answer = 1;
        ArrayList<Interval> list = new ArrayList<>();

        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);

        list.add(new Interval(routes[0][0], routes[0][1]));

        for (int i = 1; i < routes.length; i++) {
            int flag = 0;

            for (Interval interval : list) {
                if (routes[i][0] <= interval.getRight()) {
                    flag = 1;
                    temp[0] = interval.getLeft();
                    temp[1] = interval.getRight();
                    temp[2]  = routes[i][0];
                    temp[3] = routes[i][1];
                    Arrays.sort(temp);
                    interval.setLeft(temp[1]);
                    interval.setRight(temp[2]);
                    break;
                }
            }
            if (flag == 1) {
                continue;
            }

            list.add(new Interval(routes[i][0], routes[i][1]));
            answer++;
        }

        return answer;
    }
}
