//
//  main.c
//  BaekJun Algorithm 31(1712, 손익분기점)
//  https://www.acmicpc.net/problem/1712
//  Created by hyungwook on 2021/03/21.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int a, b, c;
    
    scanf("%d %d %d", &a, &b, &c);
    
    if(b >= c)
    {
        printf("-1\n");
    }
    else
    {
        int margin = c - b;
        
        printf("%d\n", a / margin + 1);
    }

    return 0;
}
