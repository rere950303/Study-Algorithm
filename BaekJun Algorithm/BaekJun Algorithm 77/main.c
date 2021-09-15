//
//  main.c
//  BaekJun Algorithm 77(1932, 정수 삼각형)
//  https://www.acmicpc.net/problem/1932
//  Created by hyungwook on 2021/04/30.
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

int max(int a, int b)
{
    return a > b ? a : b;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int dp[500][500];
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j <= i; j++)
        {
            scanf("%d", &dp[i][j]);
        }
    }
    
    for(int i = 1; i < n; i++)
    {
        for(int j = 0; j <= i; j++)
        {
            if(j == 0)
            {
                dp[i][j] = dp[i - 1][0] + dp[i][j];
            }
            else if(j == i)
            {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j];
            }
            else
            {
                dp[i][j] = dp[i][j] + max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }
    }

    mergesort1(dp[n - 1], n);
    
    printf("%d\n", dp[n - 1][0]);
  
    return 0;
}
