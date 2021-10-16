//
// 회의실 배정
//
// Created by hyungwook on 2021/10/12.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(meetings);

        int tmp = 0;

        for (Meeting meeting : meetings) {
            if (meeting.start >= tmp) {
                tmp = meeting.end;
                answer++;
            }
        }

        System.out.println(answer);
    }

    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (o.end != this.end) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }
    }
}