//
// DFS(후보키)
// https://programmers.co.kr/learn/courses/30/lessons/42890
// Created by hyungwook on 2021/11/19.
//

import java.util.ArrayList;

public class Solution {
    String[][] relation;
    int lengthR;
    int lengthC;
    int answer = 0;
    ArrayList<String> key = new ArrayList<>();

    public int solution(String[][] relation) {
        this.relation = relation;
        this.lengthR = relation.length;
        this.lengthC = relation[0].length;

        for (int i = 0; i < lengthC; i++) {
            dfs(i + 1, 0, 0, "");
        }

        return answer;
    }

    private void dfs(int count, int start, int l, String tmp) {
        if (l == count) {
            if (isUnique(tmp)) {
                answer++;
            }
        } else {
            for (int i = start; i < lengthC; i++) {
                dfs(count, i + 1, l + 1, tmp + i);
            }
        }
    }

    private boolean isUnique(String tmp) {
        for (int i = 0; i < key.size(); i++) {
            int flag = 0;
            for (char c : key.get(i).toCharArray()) {
                if (!tmp.contains(String.valueOf(c))) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return false;
            }
        }

        int length = tmp.length();
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < lengthR; i++) {
            String comb = "";
            for (int j = 0; j < length; j++) {
                comb += relation[i][Character.getNumericValue(tmp.charAt(j))];
            }
            if (list.contains(comb)) {
                return false;
            } else {
                list.add(comb);
            }
        }
        this.key.add(tmp);
        return true;
    }
}