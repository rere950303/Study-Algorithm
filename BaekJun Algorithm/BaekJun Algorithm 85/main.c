//
//  main.c
//  BaekJun Algorithm 85(9251, LCS)
//  https://www.acmicpc.net/problem/9251
//  Created by hyungwook on 2021/05/02.
//

#include <stdio.h>
#include <string.h>

int Max(int a, int b)
{
    return a > b ? a : b;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    char s1[1001];
    char s2[1001];
    
    scanf("%s", s1);
    scanf("%s", s2);
    
    int length1 = strlen(s1);
    int length2 = strlen(s2);
    
    int dp[length1 + 1][length2 + 1];
    
    for(int i = 0; i < length1 + 1; i++)
    {
        dp[i][0] = 0;
    }
    
    for(int i = 0; i < length2 + 1; i++)
    {
        dp[0][i] = 0;
    }
    
    for(int i = 1; i < length1 + 1; i++)
    {
        for(int j = 1; j < length2 + 1; j++)
        {
            if(s1[i - 1] == s2[j - 1])
            {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            }
            else
            {
                dp[i][j] = Max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    
    printf("%d\n", dp[length1][length2]);

    return 0;
}
