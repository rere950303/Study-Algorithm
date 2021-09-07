/**
* 회문문자열
*
* Created by hyungwook on 2021/09/05.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine().toUpperCase();
        int pl = 0;
        int pr = string.length() - 1;
        String answer = "YES";

        while (pl < pr) {
//            char c1 = Character.toLowerCase(string.charAt(pl));
//            char c2 = Character.toLowerCase(string.charAt(pr));
            char c1 = string.charAt(pl);
            char c2 = string.charAt(pr);
            if (c1 != c2) {
                answer = "NO";
                break;
            }
            pl++;
            pr--;
        }

//        StringBuilder 이용한 방법도 존재
//        String s = new StringBuilder(string).reverse().toString();
//        if (string.equalsIgnoreCase(string)) {
//        }

        System.out.println(answer);
    }
}
