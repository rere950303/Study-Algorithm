//
//  main.c
//  BaekJun Algorithm 87(12865, 평범한 배낭)
//  https://www.acmicpc.net/problem/12865
//  Created by hyungwook on 2021/05/15.
//

#include <stdio.h>

int dp[100001];

int Getmax(int a, int b)
{
    return a > b ? a: b;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n, k;
    int w[101];
    int v[101];
    
    scanf("%d %d", &n, &k);
    for(int i = 1; i <= n; i++)
    {
        scanf("%d %d", &w[i], &v[i]);
    }
    
    for(int i = 1; i <= n; i++)
    {
        for(int j = k; j >= 1; j--)
        {
            if(w[i] <= j)
            {
                dp[j] = Getmax(v[i] + dp[j - w[i]], dp[j]);
            }
        }
    }
    
    printf("%d\n", dp[k]);

    return 0;
}
