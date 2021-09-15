//
//  main.c
//  BaekJun Algorithm 37(2981, 검문)
//  https://www.acmicpc.net/problem/2981
//  Created by hyungwook on 2021/03/24.
//

#include <stdio.h>
#include <stdlib.h>

long long *buff;

long long GCD(long long a, long long b)
{
    if (a % b == 0)
    {
        return b;
    }
    
    return GCD(b, a % b);
}

void __mergesort(long long a[], int pl, int pr)
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

void mergesort1(long long a[], int n)
{
    buff = calloc(n, sizeof(long long));
    
    __mergesort(a, 0, n - 1);
    free(buff);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    long long arr1[101];
    long long arr2[101];
    long long arr3[10000];

    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%lld", &arr1[i]);
    }
    
    mergesort1(arr1, n);
    
    for(int i = 0; i < n - 1; i++)
    {
        arr2[i] = (arr1[i + 1] - arr1[i]);
    }
        
    long long x = arr2[0];
    int k = 1;
    
    while(1)
    {
        if(n - k == 1)
            break;
        x = GCD(x, arr2[k]);
        k++;
    }
    
    int j = 0;
    int count = 0;

    for(int i = 2; i * i <= x ; i++)
    {
        if(x % i == 0)
        {
            arr3[j++] = i;
            arr3[j++] = x / i;
            count++;
        }
    }
    
    long long y = arr3[2 * count - 1] - arr3[2 * count - 2];
    
    if(y == 0)
    {
        mergesort1(arr3, 2 * count - 1);
        for(int i = 0; i < 2 * count - 1; i++)
        {
            printf("%lld ", arr3[i]);
        }
        printf("%lld ", x);
    }
    else
    {
        mergesort1(arr3, 2 * count);
        for(int i = 0; i < 2 * count; i++)
        {
            printf("%lld ", arr3[i]);
        }
        printf("%lld ", x);
    }
    
    return 0;
}
