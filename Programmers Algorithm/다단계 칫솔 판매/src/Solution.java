//
// 트리(다단계 칫솔 판매)
// https://programmers.co.kr/learn/courses/30/lessons/77486
// Created by hyungwook on 2022/02/03.
//

import java.util.HashMap;
import java.util.stream.IntStream;

public class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Person> map = new HashMap<>();
        int length1 = enroll.length;
        Person center = new Person(null, 0);

        for (int i = 0; i < length1; i++) {
            String parent = referral[i];
            String name = enroll[i];

            if (parent.equals("-")) {
                map.put(name, new Person(center, 0));
            } else {
                map.put(name, new Person(map.get(parent), 0));
            }
        }

        int length2 = seller.length;

        for (int i = 0; i < length2; i++) {
            int money = amount[i] * 100;

            Person person = map.get(seller[i]);

            while (true) {
                int commission = (int) Math.floor(money * 0.1);

                if (commission < 1 || person.parent == null) {
                    person.m += money;
                    break;
                } else {
                    person.m += money - commission;
                    money = commission;
                    person = person.parent;
                }
            }
        }

        return IntStream.range(0, length1).map(i -> map.get(enroll[i]).m).toArray();
    }

    static class Person {
        Person parent;
        int m;

        public Person(Person parent, int m) {
            this.parent = parent;
            this.m = m;
        }
    }
}