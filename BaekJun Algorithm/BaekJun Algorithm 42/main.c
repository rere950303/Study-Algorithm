//
//  main.c
//  BaekJun Algorithm 42(3036, 링)
//  https://www.acmicpc.net/problem/3036
//  Created by hyungwook on 2021/03/27.
//

#include <stdio.h>

int gcd(int a, int b)
{
    if(a % b == 0)
        return b;
    return gcd(b, a % b);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int ring[100];
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &ring[i]);
    }
    
    for(int i = 1; i < n; i++)
    {
        int x = gcd(ring[0], ring[i]);
        printf("%d/%d\n", ring[0] / x, ring[i] / x);
    }
   
    return 0;
}
