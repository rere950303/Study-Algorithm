package com.company;

import java.util.Comparator;

public class ListComparator1 implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        int startingTime1 = o1.getStartingTime();
        int startingTime2 = o2.getStartingTime();

        if(startingTime1 > startingTime2)
            return 1;
        else if(startingTime1 < startingTime2)
            return -1;
        else
            return 0;
    }
}
