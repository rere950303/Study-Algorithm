//
// 이분탐색(금과 은 운반하기)
// https://programmers.co.kr/learn/courses/30/lessons/86053?language=java
// Created by hyungwook on 2022/02/05.
//

public class Solution {

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        long pl = 1;
        long pr = (long) (4 * Math.pow(10, 14));

        while (pl <= pr) {
            long pc = (pl + pr) / 2;

            if (canConstruct(a, b, g, s, w, t, pc)) {
                answer = pc;
                pr = pc - 1;
            } else {
                pl = pc + 1;
            }
        }

        return answer;
    }

    private boolean canConstruct(int a, int b, int[] g, int[] s, int[] w, int[] t, long time) {
        int length = w.length;
        long gold = 0;
        long silver = 0;
        long sum = 0;

        for (int i = 0; i < length; i++) {
            long count = time / (t[i] * 2);

            if (time % (2 * t[i]) >= t[i]) {
                count++;
            }

            long weight = count * w[i];

            gold += g[i] >= weight ? weight : g[i];
            silver += s[i] >= weight ? weight : s[i];
            sum += g[i] + s[i] >= weight ? weight : g[i] + s[i];
        }

        return gold >= a && silver >= b && sum >= a + b ? true : false;
    }
}
