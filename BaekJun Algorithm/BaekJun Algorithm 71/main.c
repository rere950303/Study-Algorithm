//
//  main.c
//  BaekJun Algorithm 71(1003, 피보나치 함수)
//  https://www.acmicpc.net/problem/1003
//  Created by hyungwook on 2021/04/28.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int t, n;
    int dp[41];
    
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    
    for(int i = 3; i < 41; i++)
    {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    
    scanf("%d", &t);
    
    for(int i = 0; i < t; i++)
    {
        scanf("%d", &n);
        if(n == 0)
        {
            printf("1 0\n");
        }
        else if(n == 1)
        {
            printf("0 1\n");
        }
        else
        {
            printf("%d %d\n", dp[n - 1], dp[n]);
        }
    }

    return 0;
}
