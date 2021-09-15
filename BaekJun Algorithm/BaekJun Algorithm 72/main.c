//
//  main.c
//  BaekJun Algorithm 72(9184, 신나는 함수 실행)
//  https://www.acmicpc.net/problem/9184
//  Created by hyungwook on 2021/04/28.
//

#include <stdio.h>

int dp[21][21][21];

int w(int a, int b, int c)
{
    if(a <= 0 || b <= 0 || c <= 0)
    {
        return 1;
    }
    else if(a > 20 || b > 20 || c > 20)
    {
        return w(20, 20, 20);
    }
    else if(a < b && b < c)
    {
        if(dp[a][b][c] != 0)
            return dp[a][b][c];
        else
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
    }
    else
    {
        if(dp[a][b][c] != 0)
            return dp[a][b][c];
        else
            return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int a, b, c;
    
    while(1)
    {
        scanf("%d %d %d", &a, &b, &c);
        if(a == -1 && b == -1 && c == -1)
            break;
        printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
    }
    
    return 0;
}
