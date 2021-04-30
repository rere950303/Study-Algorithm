//
//  main.c
//  BaekJun Algorithm 76(1149, RGB거리)
//  https://www.acmicpc.net/problem/1149
//  Created by hyungwook on 2021/04/30.
//

#include <stdio.h>

int min(int a, int b)
{
    return a > b ? b : a;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int a[1001][3];
    int dp[1001][3];
    int n, minmnum;
    
    scanf("%d", &n);
    for(int i = 0 ; i < n; i++)
    {
        scanf("%d %d %d", &a[i + 1][0], &a[i + 1][1], &a[i + 1][2]);
    }
    
    dp[0][0] = dp[0][1] = dp[0][2] = 0;
    
    for(int i = 0; i < n; i++)
    {
        dp[i + 1][0] = min(dp[i][1], dp[i][2]) + a[i + 1][0];
        dp[i + 1][1] = min(dp[i][0], dp[i][2]) + a[i + 1][1];
        dp[i + 1][2] = min(dp[i][1], dp[i][0]) + a[i + 1][2];
    }
    
    minmnum = dp[n][0] > dp[n][1] ? dp[n][1] : dp[n][0];
    minmnum = minmnum > dp[n][2] ? dp[n][2] : minmnum;

    printf("%d\n", minmnum);

    return 0;
}
