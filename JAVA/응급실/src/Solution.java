//
// 응급실
//
// Created by hyungwook on 2021/09/26.
//

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Queue<Node> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[] arr = new Integer[n];
        int pc = 0;
        int answer = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            queue.add(new Node(i, arr[i]));
        }

        Arrays.sort(arr, Collections.reverseOrder());

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.risk == arr[pc]) {
                pc++;
                if (node.index == m) {
                    System.out.println(answer);
                    break;
                }
                answer++;
            } else {
                queue.add(node);
            }
        }
    }

    static class Node {
        int index;
        int risk;

        public Node(int index, int risk) {
            this.index = index;
            this.risk = risk;
        }
    }
}
