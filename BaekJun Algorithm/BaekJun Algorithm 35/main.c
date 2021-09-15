//
//  main.c
//  BaekJun Algorithm 35(1010, 다리 놓기)
//  https://www.acmicpc.net/problem/1010
//  Created by hyungwook on 2021/03/23.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int t;
    int n, m;
    
    scanf("%d", &t);
    
    long long dp[30][30];
    
    dp[1][0] = 1;
    dp[1][1] = 1;
    
    for(int i = 2; i <= 29; i++)
    {
        for(int j = i; j >= 1; j--)
        {
            if(j == i)
            {
                dp[i][j] = 1;
            }
            else if(j == 1)
            {
                dp[i][j] = i;
            }
            else
            {
                dp[i][j] = (dp[i- 1][j - 1] + dp[i - 1][j]);
            }
        }
    }
    
    for(int i = 0; i < t; i++)
    {
        scanf("%d%d", &n, &m);
        printf("%lld\n", dp[m][n]);
    }
    
    return 0;
}
