//
//  main.c
//  BaekJun Algorithm 86(1912, 연속합)
//  https://www.acmicpc.net/problem/1912
//  Created by hyungwook on 2021/05/13.
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
            a[k++] = (buff[j] >= a[i] ? buff[j++] : a[i++]);
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
    int arr[100000];
    int dp[100000];
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    
    dp[0] = arr[0];
    
    for(int i = 1; i < n; i++)
    {
        dp[i] = (dp[i - 1] + arr[i] > arr[i]) ? dp[i - 1] + arr[i] : arr[i];
    }
    
    mergesort1(dp, n);
    
    printf("%d\n", dp[0]);
      
    return 0;
}
