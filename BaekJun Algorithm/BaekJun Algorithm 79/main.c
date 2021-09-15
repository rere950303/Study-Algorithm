//
//  main.c
//  BaekJun Algorithm 79(1463, 1로 만들기)
//  https://www.acmicpc.net/problem/1463
//  Created by hyungwook on 2021/04/30.
//

#include <stdio.h>

int min(int a, int b)
{
    return a > b ? b : a;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int dp[1000001];
    
    dp[1] = 0;
    scanf("%d", &n);
    for(int i = 2; i <= n; i++)
    {
        dp[i] = dp[i - 1] + 1;
        if(i % 2 == 0)
        {
            dp[i] = min(dp[i] , dp[i / 2] + 1);
        }
        if(i % 3 == 0)
        {
            dp[i] = min(dp[i], dp[i / 3] + 1);
        }
    }
    
    printf("%d\n", dp[n]);
 
    return 0;
}
