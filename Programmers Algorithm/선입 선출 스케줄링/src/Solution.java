//
// 이분탐색(선입 선출 스케줄링)
// https://programmers.co.kr/learn/courses/30/lessons/12920
// Created by hyungwook on 2022/02/27.
//

public class Solution {

    public int solution(int n, int[] cores) {
        int pl = 0;
        int pr = cores[0] * n;
        int amount = 0;
        int time = 0;

        while (pl <= pr) {
            int mid = (pl + pr) / 2;
            int tmp = getAmount(mid, cores);

            if (tmp >= n) {
                amount = tmp;
                time = mid;
                pr = mid - 1;
            } else {
                pl = mid + 1;
            }
        }

        amount -= n;
        int answer = 0;

        for (int i = cores.length - 1; i >= 0; i--) {
            if (time % cores[i] == 0) {
                if (amount == 0) {
                    answer = i + 1;
                    break;
                }
                amount--;
            }
        }

        return answer;
    }

    private int getAmount(int time, int[] cores) {
        int amount = cores.length;

        for (int i = 0; i < cores.length; i++) {
            amount += time / cores[i];
        }

        return amount;
    }
}