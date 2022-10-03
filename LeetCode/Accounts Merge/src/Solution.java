//
// Union Find, Array, DFS, String(Accounts Merge)
// https://leetcode.com/problems/accounts-merge/
// Created by hyungwook on 2022/06/30.
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    int[] boss;

    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        HashMap<String, Integer> map = new HashMap<>();
        boss = new int[accountList.size()];
        for (int i = 0; i < accountList.size(); i++) {
            boss[i] = i;
        }

        for (int i = 0; i < accountList.size(); i++) {
            List<String> account = accountList.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (map.containsKey(email)) {
                    union(map.get(email), i);
                } else {
                    map.put(email, i);
                }
            }
        }

        HashMap<Integer, ArrayList<String>> components = new HashMap<>();

        for (String email : map.keySet()) {
            int boss = find(map.get(email));

            if (!components.containsKey(boss)) {
                components.put(boss, new ArrayList<>());
            }
            components.get(boss).add(email);
        }

        List<List<String>> answer = new ArrayList<>();

        for (Integer group : components.keySet()) {
            List<String> tmp = new ArrayList<>();
            tmp.add(accountList.get(group).get(0));
            tmp.addAll(components.get(group).stream().sorted().collect(Collectors.toList()));
            answer.add(tmp);
        }
        return answer;
    }

    private void union(int a, int b) {
        int aBoss = find(a);
        int bBoss = find(b);

        if (aBoss != bBoss) {
            boss[aBoss] = bBoss;
        }
    }

    private int find(int a) {
        if (boss[a] == a) {
            return a;
        }

        return boss[a] = find(boss[a]);
    }
}