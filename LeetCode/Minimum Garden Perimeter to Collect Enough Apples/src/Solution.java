//
// Binary Search, Math(Minimum Garden Perimeter to Collect Enough Apples)
// https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/
// Created by hyungwook on 2022/03/25.
//

public class Solution {

    public long minimumPerimeter(long neededApples) {
        long answer = 1;
        long pl = 1;
        long pr = 70000;

        while (pl <= pr) {
            long mid = (pl + pr) / 2;

            if (canCollect(mid, neededApples)) {
                answer = mid * 8;
                pr = mid - 1;
            } else {
                pl = mid + 1;
            }
        }

        return answer;
    }

    private boolean canCollect(long l, long neededApples) {
        return 4 * l * l * l + 6 * l * l + 2 * l >= neededApples;
    }
}