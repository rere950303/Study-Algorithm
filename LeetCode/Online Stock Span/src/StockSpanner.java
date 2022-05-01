//
// Stack, Design(Online Stock Span)
// https://leetcode.com/problems/online-stock-span/
// Created by hyungwook on 2022/04/11.
//

import java.util.Stack;

public class StockSpanner {

    private final Stack<Pair> stack = new Stack<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int count = 1;

        while (!stack.isEmpty() && stack.peek().v <= price) {
            count += stack.pop().count;
        }
        stack.add(new Pair(count, price));

        return stack.peek().count;
    }

    public static class Pair {
        int count;
        int v;

        public Pair(int count, int v) {
            this.count = count;
            this.v = v;
        }
    }
}