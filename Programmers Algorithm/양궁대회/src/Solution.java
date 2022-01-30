//
// DFS(양궁대회)
// https://programmers.co.kr/learn/courses/30/lessons/92342?language=java
// Created by hyungwook on 2022/01/22.
//

public class Solution {

    int max = Integer.MIN_VALUE;
    int n;
    int[] info;
    int[] answer = new int[11];

    public int[] solution(int n, int[] info) {
        this.info = info;
        this.n = n;
        boolean[] check = new boolean[10];

        dfs(check, 0);

        if (max == Integer.MIN_VALUE) {
            return new int[]{-1};
        }
        return answer;
    }

    private void dfs(boolean[] check, int l) {
        if (l == 10) {
            int interval = getInterval(check);

            if (interval > 0) {
                if (interval > max) {
                    max = interval;
                    answer = makeAnswer(check);
                } else if (interval == max) {
                    int[] tmp = makeAnswer(check);

                    for (int i = 10; i >= 0; i--) {
                        if (answer[i] > tmp[i]) {
                            break;
                        } else if (answer[i] < tmp[i]) {
                            answer = tmp;
                            break;
                        }
                    }
                }
            }
        } else {
            check[l] = false;
            dfs(check, l + 1);
            check[l] = true;
            dfs(check, l + 1);
        }
    }

    private int getInterval(boolean[] check) {
        int partnerScore = 0;
        int score = 0;
        int count = 0;

        for (int i = 0; i < 10; i++) {
            if (check[i]) {
                score += 10 - i;
                count += info[i] + 1;
            } else if (!check[i] && info[i] != 0) {
                partnerScore += 10 - i;
            }
        }

        if (count > n) {
            return -1;
        } else {
            return score - partnerScore;
        }
    }

    private int[] makeAnswer(boolean[] check) {
        int[] tmp = new int[11];
        int count = 0;

        for (int i = 0; i < 10; i++) {
            if (check[i]) {
                tmp[i] = info[i] + 1;
                count += tmp[i];
            } else {
                tmp[i] = 0;
            }
        }

        if (count < n) {
            tmp[10] = n - count;
        }

        return tmp;
    }
}