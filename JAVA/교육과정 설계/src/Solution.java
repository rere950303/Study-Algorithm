//
// 교육과정 설계
//
// Created by hyungwook on 2021/09/26.
//

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        Queue<Character> queue = new LinkedList<>();

        for (char x : str1.toCharArray()) {
            queue.offer(x);
        }

        for (char x : str2.toCharArray()) {
            if (!queue.isEmpty() && queue.peek() == x) {
                queue.poll();
            }
        }

        if (queue.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}