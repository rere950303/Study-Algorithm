//
// Leader(EquiLeader)
// https://app.codility.com/programmers/lessons/8-leader/equi_leader/
// Created by hyungwook on 2021/11/11.
//

import java.util.HashMap;

public class Solution {

    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int totalCount = 0;
        int dominator = 0;
        int answer = 0;

        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (max < map.get(i)) {
                max = map.get(i);
                dominator = i;
            }
        }

        if (max <= A.length / 2) {
            return 0;
        }

        for (int i : A) {
            if (i == dominator) {
                totalCount++;
            }
        }

        int frontCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == dominator) {
                frontCount++;
            }

            if (frontCount > (i + 1) / 2 && (totalCount - frontCount) > (A.length - i - 1) / 2) {
                answer++;
            }
        }

        return answer;
    }
}
