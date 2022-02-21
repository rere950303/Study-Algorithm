//
// Data Structures(CountBoundedSlices)
// https://app.codility.com/programmers/trainings/7/count_bounded_slices/
// Created by hyungwook on 2022/02/19.
//

public class Solution {

    public int solution(int K, int[] A) {
        int length = A.length;
        int[] maxQ = new int[length];
        int[] posMaxQ = new int[length];
        int[] minQ = new int[length];
        int[] posMinQ = new int[length];

        int firstMax = 0;
        int lastMax = -1;
        int firstMin = 0;
        int lastMin = -1;
        int j = 0;
        int answer = 0;

        for (int i = 0; i < length; i++) {
            while (j < length) {
                while (lastMax >= firstMax && maxQ[lastMax] <= A[j]) {
                    lastMax--;
                }
                lastMax++;
                maxQ[lastMax] = A[j];
                posMaxQ[lastMax] = j;

                while (lastMin >= firstMin && minQ[lastMin] >= A[j]) {
                    lastMin--;
                }
                lastMin++;
                minQ[lastMin] = A[j];
                posMinQ[lastMin] = j;

                if (maxQ[firstMax] - minQ[firstMin] <= K) {
                    j++;
                } else {
                    break;
                }
            }

            answer += j - i;

            if (answer > 1000000000) {
                return 1000000000;
            }
            if (posMinQ[firstMin] == i) {
                firstMin++;
            }
            if (posMaxQ[firstMax] == i) {
                firstMax++;
            }
        }

        return answer;
    }
}