//
//  main.c
//  BaekJun Algorithm 103(10870, 피보나치 수 5)
//  https://www.acmicpc.net/problem/10870
//  Created by hyungwook on 2021/05/20.
//

#include <stdio.h>

int fabonachi(int n)
{
    if(n == 1)
        return 1;
    else if(n == 0)
        return 0;
    else
        return fabonachi(n - 1) + fabonachi(n - 2);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    
    scanf("%d", &n);
    
    long x = fabonachi(n);
    
    printf("%ld\n", x);

    return 0;
}
