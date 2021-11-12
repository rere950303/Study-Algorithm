//
// 규칙 찾기(문자열 압축)
// https://programmers.co.kr/learn/courses/30/lessons/60057
// Created by hyungwook on 2021/11/09.
//

import java.util.ArrayList;

public class Solution {
    public int solution(String s) {
        int answer = s.length();
        int length = s.length();

        for (int i = 1; i <= length / 2; i++) {
            String comp = "";
            ArrayList<String> list = new ArrayList<>();
            String tmp = new String(s);

            while (tmp.length() >= i) {
                list.add(tmp.substring(0, i));
                tmp = tmp.substring(i, tmp.length());
            }
            list.add(tmp);

            int j = 0;

            while (j < list.size()) {
                int l = 1;
                int k = j + 1;

                String start = list.get(j);
                for (; k < list.size(); k++) {
                    if (start.equals(list.get(k))) {
                        l++;
                        continue;
                    }
                    break;
                }
                comp += start;
                if (l != 1) {
                    comp += l;
                }
                j = k;
            }
            answer = Math.min(answer, comp.length());
        }

        return answer;
    }
}
