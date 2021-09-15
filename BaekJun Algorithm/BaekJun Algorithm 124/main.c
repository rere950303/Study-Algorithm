//
//  main.c
//  BaekJun Algorithm 124(ATM, 11399)
//  https://www.acmicpc.net/problem/11399
//  Created by hyungwook on 2021/06/24.
//

#include <stdio.h>
#include <stdlib.h>

int *buff;

void __mergesort(int a[], int pl, int pr)
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
            a[k++] = (buff[j] <= a[i] ? buff[j++] : a[i++]);
        }
        while(j < p)
        {
            a[k++] = buff[j++];
        }
    }
}

void mergesort1(int a[], int n)
{
    buff = calloc(n, sizeof(int));
    __mergesort(a, 0, n - 1);
    free(buff);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int *time;
    
    scanf("%d", &n);
    time = calloc(n, sizeof(int));
    
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &time[i]);
    }
    
    mergesort1(time, n);
    
    int sum = 0;
    
    for(int i = 0; i < n; i++)
    {
        sum += time[i] * (n - i);
    }
    
    printf("%d\n", sum);

    return 0;
}
