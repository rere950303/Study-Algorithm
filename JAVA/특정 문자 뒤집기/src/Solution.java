/**
* 특정 문자 뒤집기
*
* Created by hyungwook on 2021/09/04.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder string = new StringBuilder(sc.nextLine());
        int length = string.length();
        int pl = 0;
        int pr = length - 1;

        while (pl < pr) {
            while (!Character.isAlphabetic(string.charAt(pl))) {
                pl++;
            }
            while (!Character.isAlphabetic(string.charAt(pr))) {
                pr--;
            }

            if (Character.isAlphabetic(string.charAt(pl)) && Character.isAlphabetic(string.charAt(pr))) {
                char temp = string.charAt(pl);
                string.setCharAt(pl, string.charAt(pr));
                string.setCharAt(pr, temp);
                pl++;
                pr--;
            }
        }

        System.out.println(string);
    }
}
