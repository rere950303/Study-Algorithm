//
// DFS(5주차_모음사전)
// https://programmers.co.kr/learn/courses/30/lessons/84512?language=java
// Created by hyungwook on 2021/10/23.
//

public class Solution {

    char word[] = new char[]{'A', 'E', 'I', 'O', 'U'};
    String target;
    int flag = 0;
    int answer = 0;
    int count = 0;

    public int solution(String word) {
        target = word;
        String tmp = "";

        dfs(0, tmp);

        return answer;
    }

    private void dfs(int L, String tmp) {
        if (flag == 1) {
            return;
        }
        if (tmp.equals(target)) {
            flag = 1;
            answer = count;
        }
        if (L == 5) {
            return;
        } else {
            for (int i = 0; i < 5; i++) {
                count++;
                dfs(L + 1, tmp + word[i]);
            }
        }
    }
}