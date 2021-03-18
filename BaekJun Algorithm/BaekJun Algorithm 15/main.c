//
//  main.c
//  BaekJun Algorithm 15
//
//  Created by hyungwook on 2021/03/18.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct __point {
    int x;
    int y;
} Point;

Point *buff[100000];

void __mergesort(Point *a[], int pl, int pr)
{
    if(pl < pr)
    {
        int j = 0;
        int p = 0;
        int pc = (pl + pr) / 2;
        int i;
        int k = pl;
        
        __mergesort(a, pl, pc);
        __mergesort(a, pc + 1, pr);
        
        for(i = pl; i <= pc; i++)
        {
            buff[p++] = a[i];
        }
        while(i <= pr && j < p)
        {
            if(buff[j]->x < a[i]->x)
            {
                a[k++] = buff[j++];
            }
            else if((buff[j]->x == a[i]->x) && (buff[j]->y < a[i]->y))
            {
                a[k++] = buff[j++];
            }
            else
            {
                a[k++] = a[i++];
            }
        }
        while(j < p)
        {
            a[k++] = buff[j++];
        }
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n = 0;
    Point *list[100000];
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        list[i] = calloc(1, sizeof(Point));
        scanf("%d %d", &list[i]->x, &list[i]->y);
    }
    
    __mergesort(list, 0, n - 1);
    
    for(int i = 0; i < n; i++)
    {
        printf("%d %d\n", list[i]->x, list[i]->y);
    }

    return 0;
}
