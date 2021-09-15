//
//  main.c
//  BaekJun Algorithm 108(1018, 체스판 다시 칠하기)
//  https://www.acmicpc.net/problem/1018
//  Created by hyungwook on 2021/05/24.
//

#include <stdio.h>

int n, m, count;
char *black[8];
char *white[8];

char s1[8] = "BWBWBWBW";
char s2[8] = "WBWBWBWB";

int blackcount(char *a)
{
    count = 0;
    
    for(int i = 0; i < 8; i++)
    {
        for(int j = 0; j < 8; j++)
        {
            if(black[i][j] != a[j])
                count++;
        }
        a += m;
    }
    return count;
}

int whitecount(char *a)
{
    count = 0;
    
    for(int i = 0; i < 8; i++)
    {
        for(int j = 0; j < 8; j++)
        {
            if(white[i][j] != a[j])
                count++;
        }
        a += m;
    }
    return count;
}

int minvalue(int a, int b)
{
    return a < b ? a : b;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    for(int i = 0; i < 8; i += 2)
    {
        black[i] = s1;
        white[i + 1] = s1;
    }
    for(int i = 1; i < 8; i += 2)
    {
        black[i] = s2;
        white[i - 1] = s2;
    }
    
    scanf("%d %d", &n, &m);
    getchar();
    
    char sqare[n][m];
    
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < m; j++)
        {
            scanf("%c", &sqare[i][j]);
        }
        getchar();
    }
    
    int color[n - 7][m - 7];
    int minmum = 64;
        
    for(int i = 0; i < n - 7; i++)
    {
        for(int j = 0; j < m - 7; j++)
        {
            int a = blackcount(&sqare[i][j]);
            int b = whitecount(&sqare[i][j]);
            
            color[i][j] = minvalue(a, b);
        }
    }
    
    for(int i = 0; i < n - 7; i++)
    {
        for(int j = 0; j < m - 7; j++)
        {
            minmum = minvalue(minmum, color[i][j]);
        }
    }
    
    printf("%d\n", minmum);

    return 0;
}
