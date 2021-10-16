//
// 씨름 선수
//
// Created by hyungwook on 2021/10/12.
//

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(people);
        int max = Integer.MIN_VALUE;

        for (Person person : people) {
            if (person.x > max) {
                max = person.x;
                answer++;
            }
        }

        System.out.println(answer);
    }

    static class Person implements Comparable<Person>{
        int h;
        int x;

        public Person(int h, int x) {
            this.h = h;
            this.x = x;
        }

        @Override
        public int compareTo(Person o) {
            return o.h - this.h;
        }
    }
}