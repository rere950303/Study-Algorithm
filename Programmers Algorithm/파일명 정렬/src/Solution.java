//
// 정렬(파일명 정렬)
// https://programmers.co.kr/learn/courses/30/lessons/17686?language=java
// Created by hyungwook on 2022/01/20.
//

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public String[] solution(String[] files) {
        ArrayList<File> list = new ArrayList<>();

        for (String file : files) {
            int headIndex = getHead(file);
            int numberIndex = getNumber(headIndex, file);

            String head = file.substring(0, headIndex);
            String number = file.substring(headIndex, numberIndex);
            String tail = file.substring(numberIndex, file.length());
            list.add(new File(head, number, tail));
        }

        Collections.sort(list);

        return list.stream().map(o -> o.getH() + o.getN() + o.getT()).toArray(String[]::new);
    }

    private int getHead(String file) {
        int pc = 0;

        while (!Character.isDigit(file.charAt(pc))) {
            pc++;
        }

        return pc;
    }

    private int getNumber(int head, String file) {
        int pc = head;

        while (pc < file.length() && Character.isDigit(file.charAt(pc))) {
            pc++;
        }

        return pc;
    }

    static class File implements Comparable<File> {
        String h;
        String n;
        String t;

        public String getH() {
            return h;
        }

        public String getN() {
            return n;
        }

        public String getT() {
            return t;
        }

        public File(String h, String n, String t) {
            this.h = h;
            this.n = n;
            this.t = t;
        }

        @Override
        public int compareTo(File o) {
            if (!this.h.toUpperCase().equals(o.h.toUpperCase())) {
                return this.h.toUpperCase().compareTo(o.h.toUpperCase());
            } else {
                return Integer.valueOf(this.n) - Integer.valueOf(o.n);
            }
        }
    }
}