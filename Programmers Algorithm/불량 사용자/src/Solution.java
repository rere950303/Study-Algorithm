//
// DFS(불량 사용자)
// https://programmers.co.kr/learn/courses/30/lessons/64064?language=java
// Created by hyungwook on 2021/11/23.
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    HashMap<String, ArrayList<String>> map;
    ArrayList<ArrayList<String>> list;
    int length;
    int answer = 0;
    ArrayList<HashSet<String>> combination = new ArrayList<>();

    public int solution(String[] user_id, String[] banned_id) {
        this.length = banned_id.length;
        map = new HashMap<>();
        for (String s : user_id) {
            map.put(s, new ArrayList<>());
        }

        for (String s : user_id) {
            dfs_Id(s.toCharArray(), "", 0);
        }

        list = new ArrayList<>();

        for (int i = 0; i < banned_id.length; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < banned_id.length; i++) {
            addPossibleUser(banned_id[i], list.get(i));
        }

        HashSet<String> tmp = new HashSet<>();
        dfs_Comb(tmp, 0);

        return answer;
    }

    private void dfs_Id(char[] arr, String tmp, int l) {
        if (arr.length == l) {
            String s = new String(arr);
            ArrayList<String> list = map.get(s);
            list.add(tmp);
        } else {
            dfs_Id(arr, tmp + "*", l + 1);
            dfs_Id(arr, tmp + arr[l], l + 1);
        }
    }

    private void addPossibleUser(String s, ArrayList<String> strings) {
        for (String s1 : map.keySet()) {
            ArrayList<String> list = map.get(s1);
            if (list.contains(s)) {
                strings.add(s1);
            }
        }
    }

    private void dfs_Comb(HashSet<String> tmp, int l) {
        if (l == length) {
            if (isUnique(tmp)) {
                answer++;
            }
        } else {
            for (int i = 0; i < list.get(l).size(); i++) {
                if (!tmp.contains(list.get(l).get(i))) {
                    tmp.add(list.get(l).get(i));
                    dfs_Comb(tmp, l + 1);
                    tmp.remove(list.get(l).get(i));
                }
            }
        }
    }

    private boolean isUnique(HashSet<String> tmp) {
        ArrayList<String> list = new ArrayList<>(tmp);
        for (HashSet<String> set : combination) {
            if (set.containsAll(list)) {
                return false;
            }
        }

        combination.add(new HashSet<>(list));
        return true;
    }
}