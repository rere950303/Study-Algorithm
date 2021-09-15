/**
 * 대소문자 변환
 *
 * Created by hyungwook on 2021/09/03.
 **/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder string = new StringBuilder(sc.nextLine());
        int length = string.length();

        //toCharArray 방법도 존재
        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                string.setCharAt(i, Character.toLowerCase(string.charAt(i)));
            } else {
                string.setCharAt(i, Character.toUpperCase(string.charAt(i)));
            }
        }
        System.out.println(string);
    }
}
