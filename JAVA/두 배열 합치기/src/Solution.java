/**
* 두 배열 합치기
*
* Created by hyungwook on 2021/09/18.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        int pn = 0, pm = 0;

        while (pn < n && pm < m) {
            if (arr1[pn] > arr2[pm]) {
                System.out.printf("%d ", arr2[pm++]);
            } else if (arr1[pn] < arr2[pm]) {
                System.out.printf("%d ", arr1[pn++]);
            } else {
                System.out.printf("%d %d ", arr1[pn++], arr2[pm++]);
            }
        }

        if (pn != n) {
            for (int i = pn; i < n; i++) {
                System.out.printf("%d ", arr1[i]);
            }
        }

//        while (pn < n) {
//            System.out.printf("%d ", arr1[pn++]);
//        }

        if (pm != m) {
            for (int i = pm; i < m; i++) {
                System.out.printf("%d ", arr2[i]);
            }
        }

//        while (pm < m) {
//            System.out.printf("%d ", arr2[pm++]);
//        }

    }
}
