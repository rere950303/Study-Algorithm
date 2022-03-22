//
// DFS, Backtracking, String(Restore IP Addresses)
// https://leetcode.com/problems/restore-ip-addresses/
// Created by hyungwook on 2022/03/21.
//

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Solution {

    List<String> answer = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(0);
        dfs(s, tmp, 0, 0);

        return answer;
    }

    private void dfs(String s, List<Integer> tmp, int dotNum, int l) {
        if (dotNum == 3) {
            tmp.add(s.length());
            String ip = isValid(s, tmp);
            tmp.remove(tmp.size() - 1);

            if (ip != null) {
                answer.add(ip);
            }
            return;
        }
        if (l == s.length() || dotNum > 3) {
            return;
        } else {
            dfs(s, tmp, dotNum, l + 1);
            tmp.add(l);
            dfs(s, tmp, dotNum + 1, l + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    private String isValid(String s, List<Integer> tmp) {
        for (int i = 0; i <= 3; i++) {
            if (tmp.get(i + 1) - tmp.get(i) > 3) {
                return null;
            }
        }

        StringJoiner stringJoiner = new StringJoiner(".");

        for (int i = 0; i <= 3; i++) {
            String substring = s.substring(tmp.get(i), tmp.get(i + 1));
            if ((substring.length() > 1 && substring.charAt(0) == '0') || substring.equals("")) {
                return null;
            }
            Integer integer = Integer.valueOf(substring);

            if (integer < 0 || integer > 255) {
                return null;
            } else {
                stringJoiner.add(substring);
            }
        }

        return stringJoiner.toString();
    }
}