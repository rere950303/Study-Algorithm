//
// Caterpillar method(AbsDistinct)
// https://app.codility.com/programmers/lessons/15-caterpillar_method/abs_distinct/
// Created by hyungwook on 2022/01/27.
//

import java.util.HashSet;

public class Solution {

    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();

        for (int a : A) {
            if (a <= 0) {
                set.add(Math.abs(a));
            } else {
                set.add(a);
            }
        }

        return set.size();
    }
}
