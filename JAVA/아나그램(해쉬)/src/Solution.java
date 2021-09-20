/**
* 아나그램(해쉬)
*
* Created by hyungwook on 2021/09/20.
**/

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (Character character : map1.keySet()) {
            if (!map2.containsKey(character) || map1.get(character) != map2.get(character)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
