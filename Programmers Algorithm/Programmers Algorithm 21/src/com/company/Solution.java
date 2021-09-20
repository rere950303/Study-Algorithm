//
//  Programmers Algorithm 21(큰 수 만들기)
//  https://programmers.co.kr/learn/courses/30/lessons/42883?language=java
//  Created by hyungwook on 2021/07/17.
//

package com.company;

public class Solution {
    public String solution(String number, int k) {
        int length = number.length();
        int pickNum = number.length() - k;
        String answer = "";
        char[] chars = number.toCharArray();
        int startIndex = 0;

        for (int i = pickNum; i > 0; i--) {
            char max = '0';

            for (int j = startIndex; j <= length - i; j++) {
                if (chars[j] > max) {
                    max = chars[j];
                    startIndex = j;
                    if (max == '9') {
                        break;
                    }
                }
            }
            answer += String.valueOf(max);
            startIndex += 1;
        }

        return answer;
    }
}
