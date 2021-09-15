/**
* 암호
*
* Created by hyungwook on 2021/09/07.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int charNum = sc.nextInt();
        StringBuilder signal = new StringBuilder(sc.next());
        String answer = "";

        for (int i = 0; i < charNum; i++) {
            answer += (char) Integer.parseInt(signal.substring(0, 7).replace('#', '1')
                    .replace('*', '0'), 2);
            signal.delete(0, 7);
        }

        System.out.println(answer);
    }
}
