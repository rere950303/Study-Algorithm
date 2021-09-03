/**
* 단어 뒤집기
*
* Created by hyungwook on 2021/09/03.
**/
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        //StringBuilder 방법도 존재
        for (String word : words) {
            String temp = "";
            int length = word.length();

            for (int i = length - 1; i >= 0; i--) {
                temp += word.charAt(i);
            }

            System.out.println(temp);
        }
    }
}
