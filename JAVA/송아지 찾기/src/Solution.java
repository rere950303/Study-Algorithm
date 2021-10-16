//
// 송아지 찾기
//
// Created by hyungwook on 2021/10/04.
//

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        boolean[] check = new boolean[10001];
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        check[s] = true;
        int answer = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (!check[poll - 1] && poll - 1 >= 1) {
                    queue.add(poll - 1);
                    check[poll - 1] = true;
                }
                if (!check[poll + 1]) {
                    queue.add(poll + 1);
                    check[poll + 1] = true;
                }
                if (!check[poll + 5]) {
                    queue.add(poll + 5);
                    check[poll + 5] = true;
                }
            }
            if (queue.contains(e)) {
                break;
            }
            answer++;
        }

        System.out.print(answer);
    }
}