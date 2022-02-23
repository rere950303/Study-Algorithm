//
// DFS(4단 고음)
// https://programmers.co.kr/learn/courses/30/lessons/1831
// Created by hyungwook on 2022/02/22.
//

public class Solution {

    int n;
    int numOfMultiple;
    int numOfPlus;

    public int solution(int n) {
        this.n = n;
        numOfMultiple = -1;
        long tmp = 1;

        while (tmp <= n) {
            tmp *= 3;
            numOfMultiple++;
        }

        numOfPlus = 2 * numOfMultiple;

        return dfs(n - 2, 0, 2);
    }

    private int dfs(double value, int numOfMultiple, int numOfPlus) {
        if ((int) value != value || value <= 0) {
            return 0;
        }
        if (numOfMultiple * 2 > numOfPlus || Math.ceil(numOfPlus / 2) > this.numOfMultiple || numOfMultiple * 2 > this.numOfPlus) {
            return 0;
        }
        if (value == 1 && numOfMultiple == this.numOfMultiple && numOfPlus == this.numOfPlus) {
            return 1;
        }

        return dfs(value / 3, numOfMultiple + 1, numOfPlus) + dfs(value - 1, numOfMultiple, numOfPlus + 1);
    }
}