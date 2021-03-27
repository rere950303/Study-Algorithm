//
//  main.c
//  BaekJun Algorithm 41(5086, 배수와 약수)
//  https://www.acmicpc.net/problem/5086
//  Created by hyungwook on 2021/03/27.
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
        else if(b % a == 0)
        {
            printf("factor\n");
        }
        else if(a % b == 0)
        {
            printf("multiple\n");
        }
        else
        {
            printf("neither\n");
        }
    }

    return 0;
}
