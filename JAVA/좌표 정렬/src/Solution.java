//
// 좌표 정렬
//
// Created by hyungwook on 2021/09/29.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (int[] i1, int[] i2) -> i1[1] - i2[1]);
        Arrays.sort(arr, (int[] i1, int[] i2) -> i1[0] - i2[0]);

        Arrays.stream(arr).forEach((int[] i) -> System.out.println(i[0] + " " + i[1]));
    }
}
