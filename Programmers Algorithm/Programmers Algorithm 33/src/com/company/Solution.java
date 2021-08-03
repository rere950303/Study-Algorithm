//
//  Programmers Algorithm 33(입국심사)
//  https://programmers.co.kr/learn/courses/30/lessons/43238
//  Created by hyungwook on 2021/08/02.
//
package com.company;

public class Solution {

    int[] times;
    long n;
    int length;
    long answer = 0;

    public long solution(int n, int[] times) {
        this.times = times;
        this.n = n;
        this.length = times.length;

        BinarySearch(0, (long) n * times[length - 1]);
        return answer;
    }

    private void BinarySearch(long start, long end) {
        //start와 end가 같을 경우가 최솟값일수도 있으므로 '=' 부호는 생략한다.
        if (start > end) {
            return;
        }

        long passedPerson = 0;
        long pc = (start + end) / 2;

        for (int i = 0; i < length; i++) {
            passedPerson += (pc / times[i]);
        }

        if (passedPerson < n) {
            BinarySearch(pc + 1, end);
        } else if (passedPerson > n) {
            //처리 가능한 숫자가 주어진 사람보다 많은경우 일지라도 단지 최솟값이 아닐뿐이므로 일단 answer에 대입한다.
            answer = pc;
            BinarySearch(start, pc - 1);
        } else {
            answer = pc;
            BinarySearch(start, pc - 1);
        }
    }
}
