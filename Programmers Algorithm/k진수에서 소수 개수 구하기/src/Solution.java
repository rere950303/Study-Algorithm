//
// 소수(k진수에서 소수 개수 구하기)
// https://programmers.co.kr/learn/courses/30/lessons/92335?language=java
// Created by hyungwook on 2022/01/21.
//

import java.util.*;

public class Solution {

    public int solution(int n, int k) {
        int answer = 0;
        StringBuffer radix = new StringBuffer();

        while (n >= k) {
            radix.append(n % k);
            n /= k;
        }
        radix.append(n);
        Long[] target = Arrays.stream(radix.reverse().toString().split("0")).filter(o -> !o.equals("")).map(o -> Long.valueOf(o)).toArray(Long[]::new);

        for (Long aLong : target) {
            if (isPrime(aLong) && aLong != 1) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(Long aLong) {
        for (long i = 2; i * i <= aLong; i++) {
            if (aLong % i == 0) {
                return false;
            }
        }
        return true;
    }
}