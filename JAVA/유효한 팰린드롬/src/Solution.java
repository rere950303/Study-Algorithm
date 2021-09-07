/**
* 유효한 팰린드롬
*
* Created by hyungwook on 2021/09/05.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        String reversedString = new StringBuilder(string).reverse().toString();
        String answer = "NO";

        if (string.equals(reversedString)) {
            answer = "YES";
        }

        System.out.println(answer);
    }
}
