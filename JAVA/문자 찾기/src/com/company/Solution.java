/**
* 문자 찾기
*
* Created by hyungwook on 2021/09/02.
**/
package com.company;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        char character1 = sc.next().charAt(0);
        char character2;
        int length = string.length();
        int answer = 0;

        //문자열과 문자를 모두 대문자 또는 소문자로 변경하여 카운팅하는 방법도 존재
        if (Character.isUpperCase(character1)) {
            character2 = Character.toLowerCase(character1);
        } else {
            character2 = Character.toUpperCase(character1);
        }

        //문자열을 toCharArray로 변경후 iterator로 돌리는 방법도 존재
        for (int i = 0; i < length; i++) {
            if (string.charAt(i) == character1 || string.charAt(i) == character2) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}