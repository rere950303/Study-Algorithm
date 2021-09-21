//
// 모든 아나그램 찾기
//
// Created by hyungwook on 2021/09/21.
//

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        int length = T.length();
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < length; i++) {
            mapT.put(T.charAt(i), mapT.getOrDefault(T.charAt(i), 0) + 1);
        }

        for (int i = 0; i < length - 1; i++) {
            mapS.put(S.charAt(i), mapS.getOrDefault(S.charAt(i), 0) + 1);
        }

        int pl = 0;

        for (int i = length - 1; i < S.length(); i++) {
            mapS.put(S.charAt(i), mapS.getOrDefault(S.charAt(i), 0) + 1);
            if (isAnagram(mapS, mapT)) { // mapS.equals(mapT) 메소드 존재
                answer++;
            }
            mapS.put(S.charAt(pl), mapS.get(S.charAt(pl)) - 1);
            if (mapS.get(S.charAt(pl)) == 0) {
                mapS.remove(S.charAt(pl));
            }
            pl++;
        }

        System.out.println(answer);
    }

    private static boolean isAnagram(HashMap<Character, Integer> mapS, HashMap<Character, Integer> mapT) {
        if (mapS.size() == mapT.size()) {
            for (Character character : mapT.keySet()) {
                if (mapS.get(character) != mapT.get(character)) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }
}
