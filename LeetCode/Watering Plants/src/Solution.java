//
// Array(Watering Plants)
// https://leetcode.com/problems/watering-plants/
// Created by hyungwook on 2022/03/22.
//

public class Solution {

    public int wateringPlants(int[] plants, int capacity) {
        int answer = 1;
        int currCapacity = capacity - plants[0];

        for (int i = 0; i < plants.length - 1; i++) {
            if (plants[i + 1] > currCapacity) {
                currCapacity = capacity - plants[i + 1];
                answer += (i + 1) * 2 + 1;
            } else {
                currCapacity -= plants[i + 1];
                answer++;
            }
        }

        return answer;
    }
}