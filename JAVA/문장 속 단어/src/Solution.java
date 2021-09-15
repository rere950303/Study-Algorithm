/**
* 문장 속 단어
*
* Created by hyungwook on 2021/09/03.
**/
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        int max = 0;
        String answer = "";

        String[] words = string.split(" ");

        for (String word : words) {
            if (word.length() > max) {
                max = word.length();
                answer = word;
            }
        }

        System.out.println(answer);
    }
}
