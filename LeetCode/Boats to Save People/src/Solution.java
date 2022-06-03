//
// Two Pointers, Greedy, Sorting, Array(Boats to Save People)
// https://leetcode.com/problems/boats-to-save-people/
// Created by hyungwook on 2022/06/03.
//

import java.util.Arrays;

public class Solution {

    public int numRescueBoats(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int pl = 0;
        int pr = people.length - 1;

        while (pl < pr) {
            int sum = people[pl] + people[pr];

            if (sum <= limit) {
                pl++;
            }
            pr--;
            answer++;
        }

        if (pl == pr) {
            answer++;
        }

        return answer;
    }
}