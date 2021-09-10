/**
* 보이는 학생
*
* Created by hyungwook on 2021/09/08.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        int max = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (heights[i] > max) {
                answer++;
                max = heights[i];
            }
        }

        System.out.println(answer);
    }
}