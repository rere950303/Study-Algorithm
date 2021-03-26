//
//  main.c
//  BaekJun Algorithm 36(1676, 팩토리얼 0의 개수)
//  https://www.acmicpc.net/problem/1676
//  Created by hyungwook on 2021/03/24.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int numoftwo = 0;
    int numoffive = 0;

    scanf("%d", &n);
    
    for(int i = 2; i <= n; i *= 2)
    {
        numoftwo += n / i;
    }
    
    for(int i = 5; i <= n; i *= 5)
    {
        numoffive += n / i;
    }
    
    printf("%d\n", numoftwo <= numoffive ? numoftwo : numoffive);

    return 0;
}
