//
//  main.c
//  BaekJun Algorithm 98(2562, 최댓값)
//  https://www.acmicpc.net/problem/2562
//  Created by hyungwook on 2021/05/17.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int data;
    int index;
} map;

map *buff;

void __mergesort(map a[], int pl, int pr)
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
            a[k++] = (buff[j].data <= a[i].data ? buff[j++] : a[i++]);
        }
        while(j < p)
        {
            a[k++] = buff[j++];
        }
    }
}

void mergesort1(map a[], int n)
{
    buff = calloc(n, sizeof(map));
    __mergesort(a, 0, n - 1);
    free(buff);
}

map list[9];

int main(int argc, const char * argv[]) {
    // insert code here...
    for(int i = 0; i < 9; i++)
    {
        scanf("%d", &list[i].data);
        list[i].index = i + 1;
    }
    mergesort1(list, 9);
    
    printf("%d\n%d\n", list[8].data, list[8].index);
 
    return 0;
}
