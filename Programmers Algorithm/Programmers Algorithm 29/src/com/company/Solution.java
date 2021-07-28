//
//  Programmers Algorithm 29(타겟 넘버)
//  https://programmers.co.kr/learn/courses/30/lessons/43165
//  Created by hyungwook on 2021/07/28.
//
package com.company;

public class Solution {

    int targetNum;
    int answer = 0;
    Boolean[] sign = new Boolean[20];
    Boolean[] booleans = new Boolean[]{true, false};

    public int solution(int[] numbers, int target) {
        targetNum = target;
        dfs(numbers, target, 0);

        return answer;
    }

    void dfs(int[] numbers, int target, int pos) {

        for (int i = 0; i < 2; i++) {
            sign[pos] = booleans[i];
            if (pos == numbers.length - 1) {
                cal(numbers, sign);
            } else {
                dfs(numbers, target, pos + 1);
            }
        }
    }

    private void cal(int[] numbers, Boolean[] sign) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (sign[i] == true) {
                sum += numbers[i];
            } else {
                sum -= numbers[i];
            }
        }

        if (sum == targetNum) {
            answer++;
        }
    }
}
