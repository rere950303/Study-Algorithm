//
//  Programmers Algorithm 5(베스트앨범)
//  https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
//  Created by hyungwook on 2021/06/28.
//

package com.company;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int length = genres.length;
        List<Integer> Plays = Arrays.stream(plays).boxed().collect(Collectors.toList());

        for(int i = 0; i < length; i++)
        {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        for (String key : keys) {
            ArrayList<Integer> temp = new ArrayList<>();

            for(int j = 0; j < length; j++)
            {
                if(key.equals(genres[j]))
                {
                    temp.add(plays[j]);
                }
            }

            Collections.sort(temp, Collections.reverseOrder());

            int size1 = temp.size();

            if(size1 == 1)
            {
                answer.add(Plays.indexOf(temp.get(0)));
            }
            else
            {
                int index = Plays.indexOf(temp.get(0));

                answer.add(index);
                List<Integer> integers = Plays.subList(index + 1, length);
                if (integers.indexOf(temp.get(0)) != -1)
                {
                    answer.add(integers.indexOf(temp.get(0)) + index + 1);
                }
                else
                {
                    answer.add(Plays.indexOf(temp.get(1)));
                }
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        }
    }
}
