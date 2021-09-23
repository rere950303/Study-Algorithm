//
// K번째 큰 수
//
// Created by hyungwook on 2021/09/23.
//

import java.util.*;

public class Solution {

    static HashSet<Integer> set;
    static int[] arr;
    static boolean[] check;
    static int[] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        arr = new int[n];
        set = new HashSet<Integer>();
        check = new boolean[n];
        temp = new int[3];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        addCombination(n, 0);
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        if (list.size() < k) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(k - 1));
        }
    }

    private static void addCombination(int n, int k) {
        if (k == 3) {
            set.add(Arrays.stream(temp).sum());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                temp[k] = arr[i];
                check[i] = true;
                addCombination(n, k + 1);
                check[i] = false;
            }
        }
    }
}