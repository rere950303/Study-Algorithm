//
//  main.c
//  BaekJun Algorithm 33(11051, 이항 계수 2)
//  https://www.acmicpc.net/problem/11051
//  Created by hyungwook on 2021/03/22.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int dp[1001][1001];
    int n, k;
    
    scanf("%d %d", &n, &k);
    dp[1][0] = 1;
    dp[1][1] = 1;
    
    for(int i = 2; i <= 1000; i++)
    {
        for(int j = i; j >= 0; j--)
        {
            if(j == 0 || j == i)
            {
                dp[i][j] = 1;
            }
            else
            {
                dp[i][j] = (dp[i- 1][j - 1] + dp[i - 1][j]) % 10007;
            }
        }
    }
    
    printf("%d\n", dp[n][k]);
    
    return 0;
}
