/**
* 중복문자제거
*
* Created by hyungwook on 2021/09/04.
**/

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String answer = "";
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        HashSet<Character> characters = new HashSet<>();

        for (int i = 0; i < string.length(); i++) {
            if (!characters.contains(string.charAt(i))) {
                answer += string.charAt(i);
                characters.add(string.charAt(i));
            }
        }

//        첫번째 나오는 단어인 경우의 조건을 이용한 풀이
//        for (int i = 0; i > string.length(); i++) {
//            if (string.indexOf(string.charAt(i)) == i) {
//                answer += string.charAt(i);
//            }
//        }

        System.out.println(answer);
    }
}
