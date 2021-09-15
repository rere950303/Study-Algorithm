//
//  main.c
//  BaekJun Algorithm 116(N과 M (3), 15651)
//  https://www.acmicpc.net/problem/15651
//  Created by hyungwook on 2021/06/19.
//

#include <stdio.h>

int n, m;
int pos[8];

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
        pos[i] = j;
        if(i == m)
            print();
        else
            set(i + 1);
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    scanf("%d %d", &n, &m);
    set(1);

    return 0;
}
