//
// HashMap([1차] 뉴스 클러스터링)
// https://programmers.co.kr/learn/courses/30/lessons/17677
// Created by hyungwook on 2021/11/12.
//

import java.util.HashMap;
import java.util.Set;

public class Solution {

    public int solution(String str1, String str2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int intersectionNum = 0;
        int unionNum = 0;

        int length = str1.length();

        for (int i = 0; i < length - 1; i++) {
            String s = str1.substring(i, i + 2).toUpperCase();
            if (s.replaceAll("[^A-Z]", "").length() < 2) {
                continue;
            }
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        length = str2.length();

        for (int i = 0; i < length - 1; i++) {
            String s = str2.substring(i, i + 2).toUpperCase();
            if (s.replaceAll("[^A-Z]", "").length() < 2) {
                continue;
            }
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        if (map1.size() == 0 && map2.size() == 0) {
            return 65536;
        }

        Set<String> keySet = map1.keySet();

        for (String s : keySet) {
            if (map2.containsKey(s)) {
                intersectionNum += Math.min(map1.get(s), map2.get(s));
                unionNum += Math.max(map1.get(s), map2.get(s));
                map2.remove(s);
            } else {
                unionNum += map1.get(s);
            }
        }

        for (Integer value : map2.values()) {
            unionNum += value;
        }

        return (int) ((double) intersectionNum / (double) unionNum * 65536);
    }
}
