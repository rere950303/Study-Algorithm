//
// Prime and composite numbers(Flags)
// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/
// Created by hyungwook on 2021/11/23.
//

import java.util.ArrayList;

public class Solution {

    public int solution(int[] A) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                list.add(i);
            }
        }

        int pl = 1;
        int pr = list.size();

        while (pl <= pr) {
            int pc = (pl + pr) / 2;
            int a = firstCheck(list, pc);
            int b = firstNotCheck(list, pc);

            if (Math.max(a, b) >= pc) {
                answer = pc;
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        }

        return answer;
    }

    private int firstNotCheck(ArrayList<Integer> list, int pc) {
        int tmp = 0;
        int start = 0;

        if (list.size() >= 2) {
            start = list.get(1);
            tmp++;
        }

        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) - start >= pc) {
                start = list.get(i);
                tmp++;
            }
        }

        return tmp;
    }

    private int firstCheck(ArrayList<Integer> list, int pc) {
        int tmp = 0;
        int start = 0;

        if (!list.isEmpty()) {
            start = list.get(0);
            tmp++;
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - start >= pc) {
                start = list.get(i);
                tmp++;
            }
        }

        return tmp;
    }
}