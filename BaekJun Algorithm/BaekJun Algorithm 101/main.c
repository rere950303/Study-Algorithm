//
//  main.c
//  BaekJun Algorithm 101(10872, 팩토리얼)
//  https://www.acmicpc.net/problem/10872
//  Created by hyungwook on 2021/05/20.
//

#include <stdio.h>

long factorial(int n)
{
    if(n == 0)
        return 1;
    else
        return n * factorial(n - 1);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    
    scanf("%d", &n);
    
    long x = factorial(n);
    
    printf("%ld\n", x);

    return 0;
}
