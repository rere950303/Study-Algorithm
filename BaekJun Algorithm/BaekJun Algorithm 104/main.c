//
//  main.c
//  BaekJun Algorithm 104(2447, 별 찍기 - 10)
//  https://www.acmicpc.net/problem/2447
//  Created by hyungwook on 2021/05/20.
//

#include <stdio.h>
#include <math.h>

char star[2500][2500];

void blank(int x, int y, int cnt)
{
    for(int i = x; i < x + (int)pow(3, cnt); i++)
    {
        for(int j = y; j < y + (int)pow(3, cnt); j++)
        {
            star[i][j] = ' ';
        }
    }
}

void pivot(int n, int cnt)
{
    if(n > 0)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                blank((int)pow(3, cnt) + i * (int)pow(3, cnt + 1), (int)pow(3, cnt) + j * (int)pow(3, cnt + 1), cnt);
            }
        }
        pivot(n / 3, cnt + 1);
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            star[i][j] = '*';
        }
    }
    
    pivot(n / 3, 0);
    
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            printf("%c", star[i][j]);
        }
        printf("\n");
    }

    return 0;
}
