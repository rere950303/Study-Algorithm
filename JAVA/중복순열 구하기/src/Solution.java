//
// 중복순열 구하기
//
// Created by hyungwook on 2021/10/09.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int m;
    static int n;
    static int[] tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        tmp = new int[m];

        dfs(0);
    }

    private static void dfs(int num) {
        if (num == m) {
            print();
        } else {
            for (int i = 1; i <= n; i++) {
                tmp[num] = i;
                dfs(num + 1);
            }
        }
    }

    private static void print() {
        Arrays.stream(tmp).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}