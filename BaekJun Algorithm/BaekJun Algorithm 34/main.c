//
//  main.c
//  BaekJun Algorithm 34(2004, 조합 0의 개수)
//  https://www.acmicpc.net/problem/2004
//  Created by hyungwook on 2021/03/22.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    long long n, m;
    long long numoftwo = 0;
    long long numoffive = 0;

    scanf("%lld %lld", &n, &m);
    
    for(long long i = 2; i <= n; i *= 2)
    {
        numoftwo += n / i;
    }
    
    for(long long i = 5; i <= n; i *= 5)
    {
        numoffive += n / i;
    }
    
    for(long long i = 2; i <= n - m; i *= 2)
    {
        numoftwo -= (n - m) / i;
    }
    
    for(long long i = 5; i <= n - m; i *= 5)
    {
        numoffive -= (n - m) / i;
    }
    
    for(long long i = 2; i <= m; i *= 2)
    {
        numoftwo -= m / i;
    }
    
    for(long long i = 5; i <= m; i *= 5)
    {
        numoffive -= m / i;
    }
    
    printf("%lld\n", numoftwo >= numoffive ? numoffive : numoftwo);

    return 0;
}
