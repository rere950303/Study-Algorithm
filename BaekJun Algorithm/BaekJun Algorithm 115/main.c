//
//  main.c
//  BaekJun Algorithm 115(N과 M (1), 15649)
//  https://www.acmicpc.net/problem/15649
//  Created by hyungwook on 2021/06/19.
//

#include <stdio.h>

int flag[9];
int pos[9];
int n, m;

void print(void)
{
    for(int i = 1; i <= m; i++)
    {
        printf("%d ", pos[i]);
    }
    printf("\n");
}

void set(int i)
{
    for(int j = 1; j <= n; j++)
    {
        if(flag[j] == 0)
        {
            pos[i] = j;
            if(i == m)
                print();
            else
            {
                flag[j] = 1;
                set(i + 1);
                flag[j] = 0;
            }
        }
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    
    scanf("%d %d", &n, &m);
    set(1);
 
    return 0;
}
