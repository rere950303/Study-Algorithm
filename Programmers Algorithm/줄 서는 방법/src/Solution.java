//
// factorial(줄 서는 방법)
// https://programmers.co.kr/learn/courses/30/lessons/12936?language=java
// Created by hyungwook on 2022/02/16.
//

import java.util.ArrayList;

public class Solution {

    public int[] solution(int n, long k) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new int[n];
        long fn = 1;

        for (int i = 1; i <= n; i++) {
            list.add(i);
            fn *= i;
        }

        k--;

        for (int i = n; i >= 1; i--) {
            fn /= i;

            long idx = k / fn;
            answer[n - i] = list.get((int) idx);
            k %= fn;

            list.remove((int) idx);
        }

        return answer;
    }
}