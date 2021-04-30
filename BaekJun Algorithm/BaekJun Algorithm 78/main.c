//
//  main.c
//  BaekJun Algorithm 78(2579, 계단 오르기)
//  https://www.acmicpc.net/problem/2579
//  Created by hyungwook on 2021/04/30.
//

#include <stdio.h>

int max(int a, int b)
{
    return a > b ? a : b;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int a[300];
    int dp[300];
    int n;
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    
    dp[0] = a[0];
    dp[1] = a[0] + a[1];
    dp[2] = a[2] + max(a[0], a[1]);
    
    for(int i = 3; i < n; i++)
    {
        dp[i] = max(dp[i - 2] + a[i], dp[i - 3] + a[i - 1] + a[i]);
    }
    
    printf("%d\n", dp[n - 1]);

    return 0;
}
