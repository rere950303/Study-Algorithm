//
//  main.c
//  BaekJun Algorithm 83(11054, 가장 긴 바이토닉 부분 수열)
//  https://www.acmicpc.net/problem/11054
//  Created by hyungwook on 2021/05/02.
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
    int a[1000];
    int dp_left[1000];
    int dp_right[1000];
    int dp[1000];

    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    
    dp_left[0] = 1;
    dp_right[n - 1] = 1;
    
    for(int i = 1; i < n; i++)
    {
        dp_left[i] = 1;
        for(int j = 0; j < i; j++)
        {
            if(a[i] > a[j] && dp_left[j] + 1 > dp_left[i])
            {
                dp_left[i] = dp_left[j] + 1;
            }
        }
    }
    
    for(int i = n - 2; i >= 0; i--)
    {
        dp_right[i] = 1;
        for(int j = i; j < n; j++)
        {
            if(a[i] > a[j] && dp_right[j] + 1 > dp_right[i])
            {
                dp_right[i] = dp_right[j] + 1;
            }
        }
    }
    
    for(int i = 0; i < n; i++)
    {
        dp[i] = dp_left[i] + dp_right[i];
    }
    
    mergesort1(dp, n);
    
    printf("%d\n", dp[0] - 1);

    return 0;
}
