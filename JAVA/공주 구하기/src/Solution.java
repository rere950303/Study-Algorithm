//
// 공주 구하기
//
// Created by hyungwook on 2021/09/25.
//

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < k - 1; j++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        System.out.println(queue.poll());
    }
}
