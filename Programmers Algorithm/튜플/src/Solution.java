//
// Hashmap(튜플)
// https://programmers.co.kr/learn/courses/30/lessons/64065?language=java
// Created by hyungwook on 2021/11/16.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] solution(String s) {
        String[] split = s.replaceAll("[{}]", "").split(",");
        HashMap<Integer, Integer> map = new HashMap<>();

        for (String c : split) {
            map.put(Integer.valueOf(c), map.getOrDefault(Integer.valueOf(c), 0) + 1);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (m1, m2) -> m2.getValue() - m1.getValue());

        return list.stream().mapToInt(m -> m.getKey()).toArray();
    }
}
