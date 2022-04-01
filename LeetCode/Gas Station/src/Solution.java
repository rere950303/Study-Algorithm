//
// Greedy, Array(Gas Station)
// https://leetcode.com/problems/gas-station/
// Created by hyungwook on 2022/03/30.
//

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int sum = 0;
        int answer = 0;
        int gasInTank = 0;

        for (int i = 0; i < length; i++) {
            int margin = gas[i] - cost[i];
            gasInTank += margin;
            sum += margin;

            if (gasInTank < 0) {
                answer = i + 1;
                gasInTank = 0;
            }
        }

        return sum < 0 ? -1 : answer;
    }
}