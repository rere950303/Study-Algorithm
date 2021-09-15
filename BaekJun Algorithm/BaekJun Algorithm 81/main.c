//
//  main.c
//  BaekJun Algorithm 81(10844, 쉬운 계단 수)
//  https://www.acmicpc.net/problem/10844
//  Created by hyungwook on 2021/05/01.
//

#include <stdio.h>
#define MOD 1000000000

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int dp[101][10];
    long long sum = 0;
    
    scanf("%d", &n);
    dp[1][0] = 0;
    for(int i = 1; i < 10; i++)
    {
        dp[1][i] = 1;
    }
    for(int i = 2; i <= n; i++)
    {
        dp[i][0] = dp[i - 1][1];
        dp[i][9] = dp[i - 1][8];
        for(int j = 1; j <= 8; j++)
        {
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
        }
    }
    
    for(int i = 0; i < 10; i++)
    {
        sum += dp[n][i];
    }
    
    printf("%lld\n", sum % MOD);

    return 0;
}
