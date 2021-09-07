/**
* 문자열 압축
*
* Created by hyungwook on 2021/09/07.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next() + " ";
        int length = string.length() - 1;
        char[] chars = string.toCharArray();
        int pc = 1;
        String answer = "";

        for (int i = 0; i < length; i++) {
            if (chars[i] == chars[i + 1]) {
                pc++;
                continue;
            }
            answer = answer + String.valueOf(chars[i]);
            if (pc != 1) {
                answer += String.valueOf(pc);
                pc = 1;
            }
        }

        System.out.println(answer);
    }
}
