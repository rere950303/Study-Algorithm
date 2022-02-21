//
// 2016 Contest(DwarfsRafting)
// https://app.codility.com/programmers/trainings/2/dwarfs_rafting/
// Created by hyungwook on 2022/02/17.
//

public class Solution {

    public int solution(int N, String S, String T) {
        int[][] arr = new int[4][2];

        for (int i = 0; i < 4; i++) {
            arr[i][0] = (N / 2) * (N / 2);
        }

        String[] barrels = S.split(" ");

        for (String barrel : barrels) {
            if (!barrel.equals("")) {
                int position = getPosition(barrel, N);
                arr[position][0]--;
            }
        }

        String[] dwarfs = T.split(" ");

        for (String dwarf : dwarfs) {
            if (!dwarf.equals("")) {
                int position = getPosition(dwarf, N);
                arr[position][1]++;
                arr[position][0]--;
            }
        }

        if (arr[0][0] + arr[0][1] < arr[3][1] || arr[3][0] + arr[3][1] < arr[0][1] ||
                arr[1][0] + arr[1][1] < arr[2][1] || arr[2][0] + arr[2][1] < arr[1][1]) {
            return -1;
        }

        return (Math.min(arr[0][0] + arr[0][1], arr[3][0] + arr[3][1]) + Math.min(arr[1][0] + arr[1][1], arr[2][0] + arr[2][1])) * 2
                - (arr[0][1] + arr[1][1] + arr[2][1] + arr[3][1]);
    }

    private int getPosition(String s, int n) {
        int length = s.length();
        int r = Integer.parseInt(s.substring(0, length - 1));
        int c = s.charAt(length - 1) - 64;

        if (r <= n / 2 && c <= n / 2) {
            return 0;
        } else if (r <= n / 2 && c > n / 2) {
            return 1;
        } else if (r > n / 2 && c <= n / 2) {
            return 2;
        } else {
            return 3;
        }
    }
}