/**
* 봉우리
*
* Created by hyungwook on 2021/09/15.
**/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ints = new int[n + 2][n + 2];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ints[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (ints[i][j] > ints[i - 1][j] && ints[i][j] > ints[i + 1][j] && ints[i][j] > ints[i][j - 1]
                        && ints[i][j] > ints[i][j + 1]) {
                    answer++;
                }
            }
        }

//        미리 상하좌우를 탐색하는 배열 생성후 시계방향으로 k반복문을 돌리는 방법 존재
//        int[] dx = {-1, 0, 1, 0};
//        int[] dy = {0, 1, 0, -1};
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                boolean flag = true;
//                for (int k = 0; k < 4; k++) {
//                    int nx = i + dx[k];
//                    int ny = i + dy[k];
//                    if (ints[nx][ny] >= ints[i][j]) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag) {
//                    answer++;
//                }
//            }
//        }

        System.out.println(answer);
    }
}
