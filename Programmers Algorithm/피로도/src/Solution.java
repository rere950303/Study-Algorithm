//
// DFS(피로도)
// https://programmers.co.kr/learn/courses/30/lessons/87946?language=java
// Created by hyungwook on 2021/10/25.
//

public class Solution {

    int n;
    boolean check[];
    int answer = -1;
    int flag = 0;

    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        check = new boolean[n];

        dfs(k, 0, dungeons);

        return answer;
    }

    private void dfs(int k, int L, int[][] dungeons) {
        answer = Math.max(L, answer);
        if (flag == 1) {
            return;
        }
        if (L == n) {
            flag = 1;
            answer = n;
        } else {
            for (int i = 0; i < n; i++) {
                if (!check[i] && k >= dungeons[i][0]) {
                    check[i] = true;
                    dfs(k - dungeons[i][1], L + 1, dungeons);
                    check[i] = false;
                }
            }
        }
    }
}
