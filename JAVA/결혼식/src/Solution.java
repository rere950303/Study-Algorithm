//
// 결혼식
//
// Created by hyungwook on 2021/10/12.
//

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        ArrayList<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Time(sc.nextInt(), 's'));
            list.add(new Time(sc.nextInt(), 'e'));
        }

        Collections.sort(list);
        int tmp = 0;

        for (Time time : list) {
            if (time.state == 's') {
                tmp++;
                answer = Math.max(answer, tmp);
            } else {
                tmp--;
            }
        }

        System.out.println(answer);
    }

    static class Time implements Comparable<Time> {
        int time;
        char state;

        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time != o.time) {
                return this.time - o.time;
            } else {
                return this.state - o.state;
            }
        }
    }
}