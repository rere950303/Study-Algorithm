/**
* 가장 짧은 문자거리
*
* Created by hyungwook on 2021/09/06.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        char t = sc.next().charAt(0);
        int length = string.length();

        for (int i = 0; i < length; i++) {
            int lt = string.substring(0, i).lastIndexOf(t);
            if (lt == -1) {
                System.out.printf("%d ",  string.indexOf(t) - i);
                continue;
            }
            int rt = string.indexOf(t, i);
            if (rt == -1) {
                System.out.printf("%d ",  i - string.lastIndexOf(t));
                continue;
            }

            System.out.printf("%d ", i - lt < rt - i ? i - lt : rt - i);
        }

//        반복문을 처음에서, 뒤에서 2번 돌면서 더 작은값을 넣어준다
//        int[] answer = new int[length];
//        int p = 1000;
//
//        for (int i = 0; i < length; i++) {
//            if (string.charAt(i) == t) {
//                p = 0;
//                answer[i] = p;
//            } else {
//                answer[i] = ++p;
//            }
//        }
//
//        p = 1000;
//        for (int i = length - 1; i >= 0; i--) {
//            if (string.charAt(i) == t) {
//                p = 0;
//            } else {
//                answer[i] = Math.min(++p, answer[i]);
//            }
//        }
    }
}