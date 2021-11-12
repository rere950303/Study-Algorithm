//
// DFS(단체사진 찍기)
// https://programmers.co.kr/learn/courses/30/lessons/1835
// Created by hyungwook on 2021/11/11.
//

public class Solution {

    String[] data;
    int answer;
    char[] person;
    boolean[] check;

    public int solution(int n, String[] data) {
        this.data = data;
        check = new boolean[8];
        answer = 0;
        person = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

        dfs(0, "");

        return answer;
    }

    private void dfs(int l, String tmp) {
        if (l == 8) {
            if (isSatisfy(tmp)) {
                answer++;
            }
        } else {
            for (int i = 0; i < 8; i++) {
                if (!check[i]) {
                    check[i] = true;
                    dfs(l + 1, tmp + person[i]);
                    check[i] = false;
                }
            }
        }
    }

    private boolean isSatisfy(String tmp) {
        for (String s : data) {
            char c1 = s.charAt(0);
            char c2 = s.charAt(2);
            char op = s.charAt(3);
            int reg = s.charAt(4) - '0' + 1;

            if (op == '=') {
                if (Math.abs(tmp.indexOf(c1) - tmp.indexOf(c2)) != reg) {
                    return false;
                }
            } else if (op == '>') {
                if (Math.abs(tmp.indexOf(c1) - tmp.indexOf(c2)) <= reg) {
                    return false;
                }
            } else {
                if (Math.abs(tmp.indexOf(c1) - tmp.indexOf(c2)) >= reg) {
                    return false;
                }
            }
        }

        return true;
    }
}