//
//  Programmers Algorithm 28(도둑질)
//  https://programmers.co.kr/learn/courses/30/lessons/42897?language=java
//  Created by hyungwook on 2021/07/26.
//
package com.company;

public class Solution {

    public int solution(int[] money) {
        int answer = 0;

        int[] dpFirstCheck = new int[money.length - 1];
        int[] dpFirstUncheck = new int[money.length];

        dpFirstCheck[0] = money[0];
        dpFirstCheck[1] = money[0];
        dpFirstUncheck[0] = 0;
        dpFirstUncheck[1] = money[1];

        for (int i = 2; i < money.length - 1; i++) {
            dpFirstCheck[i] = Math.max(dpFirstCheck[i - 1], dpFirstCheck[i - 2] + money[i]);
        }

        for (int i = 2; i < money.length; i++) {
            dpFirstUncheck[i] = Math.max(dpFirstUncheck[i - 1], dpFirstUncheck[i - 2] + money[i]);
        }

        return Math.max(dpFirstCheck[money.length - 2], dpFirstUncheck[money.length - 1]);
    }
}
