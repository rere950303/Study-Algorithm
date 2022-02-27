//
// Hash Table, String, Sorting(Group Anagrams)
// https://leetcode.com/problems/group-anagrams/
// Created by hyungwook on 2022/02/25.
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);

            if (map.containsKey(String.valueOf(array))) {
                map.get(String.valueOf(array)).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(String.valueOf(array), list);
            }
        }

        List<List<String>> answer = new ArrayList<>();

        for (List<String> value : map.values()) {
            answer.add(value);
        }

        return answer;
    }
}