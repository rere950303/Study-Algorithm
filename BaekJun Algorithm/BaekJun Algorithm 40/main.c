//
//  main.c
//  BaekJun Algorithm 40(1934, 최소공배수)
//  https://www.acmicpc.net/problem/1934
//  Created by hyungwook on 2021/03/27.
//

#include <stdio.h>

typedef struct __num {
    int a;
    int b;
} Num;

Num list[1000];

int gcd(int a, int b)
{
    if(a % b == 0)
        return b;
    return gcd(b, a % b);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int t;
    
    scanf("%d", &t);
    for(int i = 0; i < t; i++)
    {
        scanf("%d %d", &list[i].a, &list[i].b);
    }
    
    for(int i = 0; i < t; i++)
    {
        int x = gcd(list[i].a, list[i].b);
        printf("%d\n", x * (list[i].a / x) * (list[i].b / x));
    }

    return 0;
}
