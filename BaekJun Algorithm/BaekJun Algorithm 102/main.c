//
//  main.c
//  BaekJun Algorithm 102(11729, 하노이 탑 이동 순서)
//  https://www.acmicpc.net/problem/11729
//  Created by hyungwook on 2021/05/20.
//

#include <stdio.h>
#include <math.h>

void hanoimove(int n, int a, int b)
{
    if(n > 1)
    {
        hanoimove(n - 1, a, 6 - a - b);
    }
    printf("%d %d\n", a, b);
    if(n > 1)
    {
        hanoimove(n - 1, 6 - a - b, b);
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    
    scanf("%d", &n);
    
    printf("%d\n", (int)pow(2, n) - 1);
    
    hanoimove(n , 1 , 3);

    return 0;
}
