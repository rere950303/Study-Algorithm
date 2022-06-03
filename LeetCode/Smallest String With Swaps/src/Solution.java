//
// Union Find, Hash Table, String(Smallest String With Swaps)
// https://leetcode.com/problems/smallest-string-with-swaps/
// Created by hyungwook on 2022/06/03.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {

    int[] chars;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        chars = new int[s.length()];

        for (int i = 0; i < chars.length; i++) {
            chars[i] = i;
        }
        for (List<Integer> pair : pairs) {
            if (find(pair.get(0)) != find(pair.get(1))) {
                union(pair.get(0), pair.get(1));
            }
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int boss = find(chars[i]);
            map.putIfAbsent(boss, new ArrayList<>());
            map.get(boss).add(i);
        }
        char[] answer = new char[s.length()];

        for (List<Integer> indices : map.values()) {
            List<Character> list = new ArrayList<>();

            for (Integer index : indices) {
                list.add(s.charAt(index));
            }
            Collections.sort(list);
            for (int i = 0; i < indices.size(); i++) {
                answer[indices.get(i)] = list.get(i);
            }
        }

        return String.valueOf(answer);
    }

    private int find(int a) {
        if (chars[a] == a) {
            return a;
        }
        return chars[a] = find(chars[a]);
    }

    private void union(int a, int b) {
        int aBoss = find(a);
        int bBoss = find(b);

        if (aBoss != bBoss) {
            chars[aBoss] = bBoss;
        }
    }
}