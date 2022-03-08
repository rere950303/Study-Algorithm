//
// DFS, String(Maximum Product of the Length of Two Palindromic Subsequences)
// https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/
// Created by hyungwook on 2022/03/06.
//

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int answer = Integer.MIN_VALUE;

    public int maxProduct(String s) {
        char[] chars = s.toCharArray();
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        dfs(chars, 0, list1, list2);

        return answer;
    }

    private void dfs(char[] chars, int l, List s1, List s2) {
        if (l == chars.length) {
            if (isPalindromic(s1) && isPalindromic(s2)) {
                answer = Math.max(answer, s1.size() * s2.size());
            }
        } else {
            dfs(chars, l + 1, s1, s2);

            s1.add(chars[l]);
            dfs(chars, l + 1, s1, s2);
            s1.remove(s1.size() - 1);

            s2.add(chars[l]);
            dfs(chars, l + 1, s1, s2);
            s2.remove(s2.size() - 1);
        }
    }

    private boolean isPalindromic(List list) {
        int pl = 0;
        int pr = list.size() - 1;

        while (pl < pr) {
            if (list.get(pl) != list.get(pr)) {
                return false;
            }
            pl++;
            pr--;
        }

        return true;
    }
}