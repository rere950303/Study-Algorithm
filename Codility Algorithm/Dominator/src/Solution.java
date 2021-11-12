//
// Leader(Dominator)
// https://app.codility.com/programmers/lessons/8-leader/dominator/
// Created by hyungwook on 2021/11/11.
//

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public int solution(int[] A) {
        int max = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int length = A.length;

        for (int i = 0; i < length; i++) {
            if (map.containsKey(A[i])) {
                ArrayList<Integer> list = map.get(A[i]);
                list.add(i);
                max = Math.max(max, list.size());
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(A[i], list);
                max = Math.max(max, list.size());
            }
        }

        if (max <= length / 2) {
            return -1;
        } else {
            for (Integer integer : map.keySet()) {
                if (map.get(integer).size() == max) {
                    return map.get(integer).get(0);
                }
            }
        }

        return 0;
    }
}
