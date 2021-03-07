//
//  main.c
//  BaekJun Algorithm 12
//
//  Created by hyungwook on 2021/03/06.
//

#include <stdio.h>

int sum(int k, int n)
{
    if(k == 0)
        return n;
    if(n == 1)
        return 1;

    return sum(k - 1, n) + sum(k, n - 1);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int t = 0;
    int k[225];
    int n[225];
    
    scanf("%d", &t);

    for(int i = 0; i < t; i++)
    {
        scanf("%d", &k[i]);
        scanf("%d", &n[i]);
    }
    
    for(int i = 0; i < t; i++)
    {
        printf("%d\n", sum(k[i], n[i]));
    }
    
    return 0;
}
