//
// Hashmap(보석 쇼핑)
// https://programmers.co.kr/learn/courses/30/lessons/67258
// Created by hyungwook on 2021/11/22.
//

import java.util.HashMap;

public class Solution {

    public int[] solution(String[] gems) {
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        int length = gems.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (String gem : gems) {
            if (!map.containsKey(gem)) {
                map.put(gem, 1);
            }
        }

        int size = map.size();
        map.clear();
        int pl = 0;
        int pr = 0;

        while (pr < length) {
            while (pr < length && map.size() != size) {
                map.put(gems[pr], map.getOrDefault(gems[pr], 0) + 1);
                pr++;
            }

            if (map.size() != size) {
                break;
            }

            while (map.get(gems[pl]) != 1) {
                map.put(gems[pl], map.get(gems[pl]) - 1);
                pl++;
            }

            if (pr - pl < min) {
                min = pr - pl;
                answer[0] = pl + 1;
                answer[1] = pr;
            }
            map.remove(gems[pl]);
            pl++;
        }

        return answer;
    }
}
