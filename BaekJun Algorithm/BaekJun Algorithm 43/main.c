//
//  main.c
//  BaekJun Algorithm 43(11050, 이항 계수 1)
//  https://www.acmicpc.net/problem/11050
//  Created by hyungwook on 2021/03/27.
//

#include <stdio.h>

int factorial(int n)
{
    int k = 1;
    
    while(n >= 2)
    {
        k *= n;
        n--;
    }
    
    return k;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n, k;
    
    scanf("%d %d", &n, &k);
    printf("%d\n", factorial(n) / factorial(k) / factorial(n - k));

    return 0;
}
