//
// DFS(순위 검색)
// https://programmers.co.kr/learn/courses/30/lessons/72412?language=java
// Created by hyungwook on 2021/11/05.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {

    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    int score = 0;

    public int[] solution(String[] info, String[] query) {
        int length = query.length;
        int[] answer = new int[length];

        for (String s : info) {
            String[] split = s.split(" ");
            score = Integer.valueOf(split[4]);
            dfs("", split, 0);
        }

        for (ArrayList<Integer> value : map.values()) {
            Collections.sort(value);
        }

        for (int i = 0; i < length; i++) {
            answer[i] = count(query[i]);
        }

        return answer;
    }

    private int count(String s) {
        String[] split = s.replace(" and ", "").split(" ");

        if (!map.containsKey(split[0])) {
            return 0;
        }

        Integer score = Integer.valueOf(split[1]);
        ArrayList<Integer> list = map.get(split[0]);

        int pl = 0;
        int pr = list.size() - 1;

        while (pl <= pr) {
            int pc = (pl + pr) / 2;

            if (list.get(pc) < score) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        }

        return list.size() - pl;
    }

    private void dfs(String s, String[] split, int l) {
        if (l == 4) {
            if (map.containsKey(s)) {
                map.get(s).add(score);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(score);
                map.put(s, list);
            }
        } else {
            dfs(s + split[l], split, l + 1);
            dfs(s + "-", split, l + 1);
        }
    }
}