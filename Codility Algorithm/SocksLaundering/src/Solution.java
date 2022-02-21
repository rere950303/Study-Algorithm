//
// 2017 Contest(SocksLaundering)
// https://app.codility.com/programmers/trainings/3/socks_laundering/
// Created by hyungwook on 2022/02/17.
//

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public int solution(int K, int[] C, int[] D) {
        HashMap<Integer, Integer> clean = new HashMap<>();
        HashMap<Integer, Integer> dirty = new HashMap<>();

        for (int c : C) {
            clean.put(c, clean.getOrDefault(c, 0) + 1);
        }

        for (int d : D) {
            dirty.put(d, dirty.getOrDefault(d, 0) + 1);
        }

        int answer = 0;
        ArrayList<Integer> keyList = new ArrayList<>(clean.keySet());

        for (Integer key : keyList) {
            answer += clean.get(key) / 2;
            clean.put(key, clean.get(key) - clean.get(key) / 2 * 2);

            if (dirty.containsKey(key)) {
                int min = Math.min(Math.min(clean.get(key), dirty.get(key)), K);

                clean.put(key, clean.get(key) - min);
                dirty.put(key, dirty.get(key) - min);
                answer += min;
                K -= min;
            }
        }

        if (K != 0) {
            for (Integer value : dirty.values()) {
                int min = Math.min(K, value) / 2;

                answer += min;
                K -= min * 2;

                if (K <= 1) {
                    break;
                }
            }
        }

        return answer;
    }
}