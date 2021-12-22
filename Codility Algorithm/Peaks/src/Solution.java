//
// Prime and composite numbers(Peaks)
// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/
// Created by hyungwook on 2021/11/25.
//

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    int length;

    public int solution(int[] A) {
        this.length = A.length;
        ArrayList<Integer> peakList = new ArrayList<>();
        ArrayList<Integer> blockList = new ArrayList<>();

        for (int i = 1; i < length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peakList.add(i);
            }
        }

        if (peakList.isEmpty()) {
            return 0;
        }

        for (int i = 2; i <= peakList.size(); i++) {
            if (length % i == 0) {
                blockList.add(i);
            }
        }

        Collections.sort(blockList, Collections.reverseOrder());

        for (Integer blockNum : blockList) {
            if (isSatisfy(blockNum, peakList)) {
                return blockNum;
            }
        }

        return 1;
    }

    private boolean isSatisfy(Integer blockNum, ArrayList<Integer> peakList) {
        int blockSize = length / blockNum;
        int count = 0;
        int tmp = -1;

        if (peakList.get(0) / blockSize != 0) {
            return false;
        }

        for (Integer peak : peakList) {
            if (peak / blockSize != tmp) {
                tmp = peak / blockSize;
                count++;
            }
        }

        return count == blockNum;
    }
}