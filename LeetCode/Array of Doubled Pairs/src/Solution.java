//
// Hash Table, Greedy, Sorting(Array of Doubled Pairs)
// https://leetcode.com/problems/array-of-doubled-pairs/
// Created by hyungwook on 2022/05/02.
//

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public boolean canReorderDoubled(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer[] newArr = Arrays.stream(arr).boxed().sorted((i1, i2) -> Integer.compare(Math.abs(i1), Math.abs(i2)))
                .toArray(Integer[]::new);

        for (Integer num : newArr) {
            if (map.get(num) == 0) {
                continue;
            }
            if (map.getOrDefault(num * 2, 0) == 0) {
                return false;
            }
            map.put(num, map.get(num) - 1);
            map.put(num * 2, map.get(num * 2) - 1);
        }

        return true;
    }
}