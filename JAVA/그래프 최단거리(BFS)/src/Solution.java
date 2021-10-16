//
// 그래프 최단거리(BFS)
//
// Created by hyungwook on 2021/10/06.
//

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] check = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] answer = new int[n + 1];
        int L = 1;

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            list.get(sc.nextInt()).add(sc.nextInt());
        }

        queue.add(1);
        check[1] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> integers = list.get(queue.poll());
                for (Integer integer : integers) {
                    if (!check[integer]) {
                        check[integer] = true;
                        answer[integer] = L;
                        queue.add(integer);
                    }
                }
            }

            L++;
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + answer[i]);
        }
    }
}