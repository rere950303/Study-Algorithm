//
//  main.c
//  BaekJun Algorithm 50(10952, A+B - 5)
//  https://www.acmicpc.net/problem/10952
//  Created by hyungwook on 2021/03/29.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int a, b;
    
    while(1)
    {
        scanf("%d %d", &a, &b);
        if(a == 0 && b == 0)
            break;
        printf("%d\n", a + b);
    }

    return 0;
}
