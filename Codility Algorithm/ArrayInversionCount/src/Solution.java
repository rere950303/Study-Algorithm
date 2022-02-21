//
// Algorithmic skills(ArrayInversionCount)
// https://app.codility.com/programmers/trainings/4/array_inversion_count/
// Created by hyungwook on 2022/02/18.
//

public class Solution {

    long answer = 0;

    public int solution(int[] A) {
        mergeSort(A, 0, A.length - 1);

        return answer > 1000000000 ? -1 : (int) answer;
    }

    private void mergeSort(int[] a, int pl, int pr) {
        if (pl < pr) {
            int mid = (pl + pr) / 2;

            mergeSort(a, pl, mid);
            mergeSort(a, mid + 1, pr);

            int i;
            int p = 0;
            int j = 0;
            int k = pl;
            int[] buff = new int[mid - pl + 1];

            for (i = pl; i <= mid; i++) {
                buff[p++] = a[i];
            }

            int count = 0;
            while (i <= pr && j < p) {
                if (buff[j] > a[i]) {
                    a[k++] = a[i++];
                    count++;
                } else {
                    a[k++] = buff[j++];
                    answer += count;
                }
            }
            while (j < p) {
                a[k++] = buff[j++];
                answer += count;
            }
        }
    }
}