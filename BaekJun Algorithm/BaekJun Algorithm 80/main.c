//
//  main.c
//  BaekJun Algorithm 80(2156, 포도주 시식)
//  https://www.acmicpc.net/problem/2156
//  Created by hyungwook on 2021/04/30.
//

#include <stdio.h>

int max(int a, int b)
{
    return a > b ? a : b;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int a[10003];
    int dp[10003];
    int n;
    
    scanf("%d", &n);
    for(int i = 3; i < n + 3; i++)
    {
        scanf("%d", &a[i]);
    }
    
    for(int i = 3; i < n + 3; i++)
    {
        dp[i] = max(dp[i - 3] + a[i - 1] + a[i], dp[i - 2] + a[i]);
        dp[i] = max(dp[i], dp[i - 1]);
    }
    
    printf("%d\n", dp[n + 2]);
 
    return 0;
}
