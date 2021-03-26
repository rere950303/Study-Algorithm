//
//  main.c
//  BaekJun Algorithm 38(2609, 최대공약수와 최소공배수)
//  https://www.acmicpc.net/problem/2609
//  Created by hyungwook on 2021/03/25.
//

#include <stdio.h>

int gcd(int a, int b)
{
    if(a % b == 0)
        return b;
    else
        return gcd(b, a % b);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n, m;
    
    scanf("%d %d", &n, &m);
    
    int x = gcd(n, m);
    
    printf("%d\n%d\n", x, x * (n / x) * (m / x));

    return 0;
}
