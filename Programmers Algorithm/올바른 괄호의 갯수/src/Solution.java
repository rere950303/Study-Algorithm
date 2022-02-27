//
// 백트래킹, DFS(올바른 괄호의 갯수)
// https://programmers.co.kr/learn/courses/30/lessons/12929?language=java
// Created by hyungwook on 2022/02/26.
//

public class Solution {

    public int solution(int n) {
        return dfs(n, 0, 0);
    }

    private int dfs(int n, int open, int end) {
        if (open < end || open > n) {
            return 0;
        }
        if (open == n && end == n) {
            return 1;
        }
         return dfs(n, open + 1, end) + dfs(n, open, end + 1);
    }
}