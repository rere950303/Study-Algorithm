//
// Greedy, String(Minimum Adjacent Swaps to Reach the Kth Smallest Number)
// https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/
// Created by hyungwook on 2022/03/29.
//

import java.util.Arrays;

public class Solution {

    public int getMinSwaps(String num, int k) {
        int length = num.length();
        int[] original = new int[length];

        for (int i = 0; i < length; i++) {
            original[i] = num.charAt(i) - '0';
        }

        int[] kthSmallestNum = getKthSmallestNum(original.clone(), k);
        int answer = 0;

        for (int i = 0; i < length; i++) {
            if (original[i] != kthSmallestNum[i]) {
                int j = i + 1;

                while (original[j] != kthSmallestNum[i]) {
                    j++;
                }
                while (j != i) {
                    swap(original, j, j - 1);
                    j--;
                    answer++;
                }
            }
        }

        return answer;
    }

    private int[] getKthSmallestNum(int[] original, int k) {
        while (k-- > 0) {
            nextPermutation(original);
        }

        return original;
    }

    private void nextPermutation(int[] original) {
        int i = original.length - 2;

        for (; i >= 0; i--) {
            if (original[i] < original[i + 1]) {
                break;
            }
        }
        int swapIdx = original.length - 1;

        for (; swapIdx > i; swapIdx--) {
            if (original[swapIdx] > original[i]) {
                break;
            }
        }

        swap(original, i, swapIdx);
        Arrays.sort(original, i + 1, original.length);
    }

    private void swap(int[] original, int i, int swapIdx) {
        int tmp = original[swapIdx];
        original[swapIdx] = original[i];
        original[i] = tmp;
    }
}