//
// GCD(N개의 최소공배수)
// https://programmers.co.kr/learn/courses/30/lessons/12953?language=java
// Created by hyungwook on 2022/02/18.
//

public class Solution {

    public int solution(int[] arr) {
        int answer = arr[0];
        int length = arr.length;

        for (int i = 1; i < length; i++) {
            int gcd = gcd(answer, arr[i]);

            answer = (answer / gcd) * (arr[i] / gcd) * gcd;
        }

        return answer;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}