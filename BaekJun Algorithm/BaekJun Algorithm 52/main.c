//
//  main.c
//  BaekJun Algorithm 52(10951, A+B - 4)
//  https://www.acmicpc.net/problem/10951
//  Created by hyungwook on 2021/03/29.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int a, b;
    
    while((scanf("%d %d", &a, &b)) != EOF)
    {
        printf("%d\n", a + b);
    }

    return 0;
}
