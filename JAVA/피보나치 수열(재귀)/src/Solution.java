//
// 피보나치 수열(재귀)
//
// Created by hyungwook on 2021/10/04.
//

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> fibonacci = new ArrayList<>();

        fibonacci.add(1);
        fibonacci.add(1);

        dfs(fibonacci, n);

        fibonacci.stream().forEach(i -> System.out.print(i + " "));
    }

    private static void dfs(ArrayList<Integer> fibonacci, int n) {
        if (fibonacci.size() < n) {
            fibonacci.add(fibonacci.get(fibonacci.size() - 1) + fibonacci.get(fibonacci.size() - 2));
            dfs(fibonacci, n);
        }
    }
}
