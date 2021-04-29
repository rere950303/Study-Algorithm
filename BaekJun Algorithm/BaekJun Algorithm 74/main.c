//
//  main.c
//  BaekJun Algorithm 74(9461, 파도반 수열)
//  https://www.acmicpc.net/problem/9461
//  Created by hyungwook on 2021/04/29.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    long dp[101];
    int t, n;
    
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 2;
    dp[5] = 2;
    
    for(int i = 6; i < 101; i++)
    {
        dp[i] = dp[i - 1] + dp[i - 5];
    }
    
    scanf("%d", &t);
    for(int i = 0; i < t; i++)
    {
        scanf("%d", &n);
        printf("%ld\n", dp[n]);
    }

    return 0;
}
