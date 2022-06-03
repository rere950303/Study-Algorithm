//
// Union Find, String, Array(Satisfiability of Equality Equations)
// https://leetcode.com/problems/satisfiability-of-equality-equations/
// Created by hyungwook on 2022/06/02.
//

public class Solution {

    int[] chars = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            chars[i] = i;
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';

                union(a, b);
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';

                if (find(a) == find(b)) {
                    return false;
                }
            }
        }

        return true;
    }

    private void union(int a, int b) {
        int aBoss = find(a);
        int bBoss = find(b);

        if (aBoss != bBoss) {
            chars[aBoss] = bBoss;
        }
    }

    private int find(int aChar) {
        if (chars[aChar] == aChar) {
            return aChar;
        }

        return chars[aChar] = find(chars[aChar]);
    }
}