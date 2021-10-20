//
// 가장 높은 탑 쌓기
//
// Created by hyungwook on 2021/10/20.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Brick[] bricks = new Brick[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            bricks[i] = new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(bricks);
        dp[0] = bricks[0].h;
        int answer = dp[0];

        for (int i = 1; i < n; i++) {
            int tmp = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (bricks[i].w < bricks[j].w) {
                    tmp = Math.max(tmp, dp[j]);
                }
            }
            dp[i] = tmp + bricks[i].h;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }

    static class Brick implements Comparable<Brick> {
        int area;
        int h;
        int w;

        public Brick(int area, int h, int w) {
            this.area = area;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return o.area - this.area;
        }
    }
}