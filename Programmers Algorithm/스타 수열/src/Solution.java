//
// 해쉬맵(스타 수열)
// https://programmers.co.kr/learn/courses/30/lessons/70130
// Created by hyungwook on 2022/02/12.
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    int length;
    int[] a;

    public int solution(int[] a) {
        this.a = a;
        this.length = a.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < length; i++) {
            ArrayList<Integer> list = map.getOrDefault(a[i], new ArrayList<>());
            list.add(i);
            map.put(a[i], list);
        }

        int answer = 0;

        for (ArrayList<Integer> integers : map.values()) {
            if (integers.size() * 2 <= answer) {
                continue;
            }
            answer = Math.max(answer, getLen(integers) * 2);
        }

        return answer;
    }

    private int getLen(ArrayList<Integer> list) {
        HashSet<Integer> set = new HashSet<>();

        for (Integer integer : list) {
            if (integer > 0 && !set.contains(integer - 1) && a[integer] != a[integer - 1]) {
                set.add(integer - 1);
                continue;
            }
            if (integer < length - 1 && !set.contains(integer + 1) && a[integer] != a[integer + 1]) {
                set.add(integer + 1);
                continue;
            }
        }

        return Math.min(list.size(), set.size());
    }
}