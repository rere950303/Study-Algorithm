//
// DFS(수식 최대화)
// https://programmers.co.kr/learn/courses/30/lessons/67257
// Created by hyungwook on 2021/11/16.
//

import java.util.ArrayList;

public class Solution {

    char[] priority = new char[]{'+', '*', '-'};
    boolean[] check = new boolean[3];
    char[] tmp = new char[3];
    ArrayList<Long> num = new ArrayList<>();
    ArrayList<Character> op = new ArrayList<>();
    long answer = 0;

    public long solution(String expression) {
        String[] split = expression.replaceAll("[^0-9]", " ").split(" ");
        for (String s : split) {
            num.add(Long.valueOf(s));
        }
        String s = expression.replaceAll("[0-9]", "");
        for (char c : s.toCharArray()) {
            op.add(c);
        }

        dfs(0);

        return answer;
    }

    private void dfs(int l) {
        if (l == 3) {
            findMax();
        } else {
            for (int i = 0; i < 3; i++) {
                if (!check[i]) {
                    check[i] = true;
                    tmp[l] = priority[i];
                    dfs(l + 1);
                    check[i] = false;
                }
            }
        }
    }

    private void findMax() {
        ArrayList<Long> num = (ArrayList<Long>) this.num.clone();
        ArrayList<Character> op = (ArrayList<Character>) this.op.clone();

        for (int i = 0; i < 3; i++) {
            char c = tmp[i];
            while (op.contains(c)) {
                int index = op.indexOf(c);
                Long integer1 = num.get(index);
                Long integer2 = num.get(index + 1);

                num.remove(index + 1);
                num.remove(index);
                num.add(index, cal(c, integer1, integer2));
                op.remove(index);
            }
        }

        answer = Math.max(answer, Math.abs(num.get(0)));
    }

    private Long cal(char c, Long i1, Long i2) {
        if (c == '+') {
            return i1 + i2;
        } else if (c == '*') {
            return i1 * i2;
        } else {
            return i1 - i2;
        }
    }
}