//
// Algorithmic skills(FirstUnique)
// https://app.codility.com/programmers/trainings/4/first_unique/
// Created by hyungwook on 2022/02/18.
//

import java.util.HashMap;

public class Solution {

    public int solution(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (int a : A) {
            if (map.get(a) == 1) {
                return a;
            }
        }

        return -1;
    }
}