//
//  main.c
//  BaekJun Algorithm 105(2798, 블랙잭)
//  https://www.acmicpc.net/problem/2798
//  Created by hyungwook on 2021/05/21.
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

int maxint(int a, int b)
{
    return a > b ? a : b;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n, m;
    int arr[100];
    int max = 0;
    
    scanf("%d %d", &n, &m);
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    
    mergesort1(arr, n);
    
    for(int i = 0; i < n - 2; i++)
    {
        for(int j = i + 1; j < n - 1; j++)
        {
            for(int k = j + 1; k < n; k++)
            {
                if(arr[i] + arr[j] + arr[k] <= m)
                {
                    max = maxint(max, arr[i] + arr[j] + arr[k]);
                }
            }
        }
    }
    
    printf("%d\n", max);

    return 0;
}
