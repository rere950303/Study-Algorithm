/**
* 학급 회장(해쉬)
*
* Created by hyungwook on 2021/09/20.
**/

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String vote = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = vote.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((e1, e2) -> e2.getValue() - e1.getValue());

        System.out.println(entries.get(0).getKey());
    }
}
