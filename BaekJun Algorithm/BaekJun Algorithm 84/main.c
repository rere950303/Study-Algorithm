//
//  main.c
//  BaekJun Algorithm 84(2565, 전깃줄)
//  https://www.acmicpc.net/problem/2565
//  Created by hyungwook on 2021/05/02.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct __point {
    int x;
    int y;
} Point;

Point list[100];

Point *buff;

void __mergesort(Point a[], int pl, int pr)
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
            a[k++] = (buff[j].y <= a[i].y ? buff[j++] : a[i++]);
        }
        while(j < p)
        {
            a[k++] = buff[j++];
        }
    }
}

void mergesort1(Point a[], int n)
{
    buff = calloc(n, sizeof(Point));
    
    __mergesort(a, 0, n - 1);
    free(buff);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int dp[100];
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%d %d", &list[i].x, &list[i].y);
    }
    mergesort1(list, n);
    
    dp[0] = 1;
    
    for(int i = 1; i < n; i++)
    {
        dp[i] = 1;
        for(int j = 0; j < i; j++)
        {
            if(list[i].x > list[j].x && dp[j] + 1 > dp[i])
            {
                dp[i] = dp[j] + 1;
            }
        }
    }
    
    int max = dp[0];
    
    for(int i = 1; i < n; i++)
    {
        if(max < dp[i])
        {
            max = dp[i];
        }
    }
    
    printf("%d\n", n - max);

    return 0;
}
