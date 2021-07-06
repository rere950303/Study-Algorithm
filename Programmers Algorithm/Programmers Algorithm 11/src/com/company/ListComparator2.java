package com.company;

import java.util.Comparator;

public class ListComparator2 implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        int loadingTime1 = o1.getLoadingTime();
        int loadingTime2 = o2.getLoadingTime();

        if (loadingTime1 > loadingTime2) {
            return 1;
        } else if (loadingTime1 < loadingTime2) {
            return -1;
        } else {
            return 0;
        }
    }
}
