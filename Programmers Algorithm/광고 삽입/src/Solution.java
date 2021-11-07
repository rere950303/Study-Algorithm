//
// Two Pointer(광고 삽입)
// https://programmers.co.kr/learn/courses/30/lessons/72414#fn1
// Created by hyungwook on 2021/11/07.
//

public class Solution {

    public String solution(String play_time, String adv_time, String[] logs) {
        int sec = toSec(play_time);
        int[] arr = new int[sec + 1];

        for (String log : logs) {
            String[] split = log.split("-");
            int startTime = toSec(split[0]);
            int endTime = toSec(split[1]);

            arr[startTime]++;
            arr[endTime]--;
        }

        for (int i = 1; i <= sec; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        int advTime = toSec(adv_time);
        long sum = 0;

        for (int i = 0; i < advTime; i++) {
            sum += arr[i];
        }

        int pl = 0;
        int pr = advTime;
        int answer = 0;
        long max = sum;

        while (pr < sec) {
            sum = sum + arr[pr] - arr[pl];
            if (sum > max) {
                max = sum;
                answer = pl + 1;
            }
            pl++;
            pr++;
        }

        return String.format("%02d:%02d:%02d", answer / 3600, (answer % 3600) / 60, answer % 60);
    }

    private int toSec(String time) {
        String[] split = time.split(":");

        return 3600 * Integer.valueOf(split[0]) + 60 * Integer.valueOf(split[1]) + Integer.valueOf(split[2]);
    }
}
