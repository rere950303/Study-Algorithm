/**
* 숫자만 추출
*
* Created by hyungwook on 2021/09/06.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Integer.valueOf(sc.nextLine().replaceAll("[^0-9]", "")));
    }
}
