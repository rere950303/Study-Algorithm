//
// Matrix, Hash Table(Valid Sudoku)
// https://leetcode.com/problems/valid-sudoku/
// Created by hyungwook on 2022/02/25.
//

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Integer>> r = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> c = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> b = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            r.put(i, new HashSet<>());
            c.put(i, new HashSet<>());
            b.put(i, new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';

                HashSet<Integer> rSet = r.get(i);
                HashSet<Integer> cSet = c.get(j);
                HashSet<Integer> bSet = b.get(3 * (i / 3) + j / 3);

                if (rSet.contains(num) || cSet.contains(num) || bSet.contains(num)) {
                    return false;
                }
                rSet.add(num);
                cSet.add(num);
                bSet.add(num);
            }
        }

        return true;
    }
}