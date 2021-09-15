//
//  main.c
//  BaekJun Algorithm 73(1904, 01타일)
//  https://www.acmicpc.net/problem/1904
//  Created by hyungwook on 2021/04/29.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int dp[1000001];
    
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    
    scanf("%d", &n);
    
    for(int i = 3; i < n + 1; i++)
    {
        dp[i] = (dp[i - 2] % 15746 + dp[i - 1] % 15746) % 15746;
    }
    
    printf("%d\n", dp[n]);
    
    return 0;
}
