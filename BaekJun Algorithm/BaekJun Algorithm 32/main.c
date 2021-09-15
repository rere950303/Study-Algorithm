//
//  main.c
//  BaekJun Algorithm 32(1037, 약수)
//  https://www.acmicpc.net/problem/1037
//  Created by hyungwook on 2021/03/22.
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
    int arr[50];
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    
    mergesort1(arr, n);
    
    printf("%d\n", arr[0] * arr[n - 1]);

    return 0;
}
