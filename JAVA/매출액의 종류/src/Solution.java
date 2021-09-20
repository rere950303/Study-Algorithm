/**
* 매출액의 종류
*
* Created by hyungwook on 2021/09/20.
**/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int pl = 0;
        for (int i = k - 1; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            result.add(map.size());
            map.put(arr[pl], map.get(arr[pl]) - 1);
            if (map.get(arr[pl]) == 0) {
                map.remove(arr[pl]);
            }
            pl++;
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}