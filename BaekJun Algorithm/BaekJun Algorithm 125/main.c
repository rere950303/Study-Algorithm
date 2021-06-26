//
//  main.c
//  BaekJun Algorithm 125(쿼드트리, 1992)
//  https://www.acmicpc.net/problem/1992
//  Created by hyungwook on 2021/06/24.
//

#include <stdio.h>
#include <stdbool.h>

int n;
int quadtree[64][64];

void set(int x, int y, int pc)
{
    int spec = 0;
    bool flag = quadtree[x][y];
    
    for(int i = 0; i < pc; i++)
    {
        for(int j = 0; j < pc; j++)
        {
            if(flag != quadtree[x + i][y + j])
            {
                spec = 1;
                break;
            }
        }
    }
    
    if(spec == 0)
    {
        if(flag == false)
        {
            printf("0");
            return;
        }
        else
        {
            printf("1");
            return;
        }
    }
    
    printf("(");
    set(x, y, pc / 2);
    set(x, y + pc / 2, pc / 2);
    set(x + pc / 2, y, pc / 2);
    set(x + pc / 2, y + pc / 2, pc / 2);
    printf(")");
}

int main(int argc, const char * argv[]) {
    // insert code here...
    char temp[65][65];
    
    scanf("%d", &n);
    getchar();
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            scanf("%c", &temp[i][j]);
        }
        getchar();
    }

    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n ; j++)
        {
            quadtree[i][j] = temp[i][j] - '0';
        }
    }
        
    set(0, 0, n);

    return 0;
}
