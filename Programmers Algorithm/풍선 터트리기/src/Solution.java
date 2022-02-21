//
// 투포인터(풍선 터트리기)
// https://programmers.co.kr/learn/courses/30/lessons/68646?language=java
// Created by hyungwook on 2022/02/12.
//

public class Solution {

    public int solution(int[] a) {
        int length = a.length;
        int[] minL = new int[a.length];
        int[] minR = new int[a.length];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < length; i++) {
            if (a[i] < min) {
                minL[i] = a[i];
                min = a[i];
            } else {
                minL[i] = min;
            }
        }

        min = Integer.MAX_VALUE;
        for (int i = length - 1; i >= 0; i--) {
            if (a[i] < min) {
                minR[i] = a[i];
                min = a[i];
            } else {
                minR[i] = min;
            }
        }

        int answer = 0;

        for (int i = 0; i < length; i++) {
            if (a[i] > minL[i] && a[i] > minR[i]) {
                continue;
            }
            answer++;
        }

        return answer;
    }
}