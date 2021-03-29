//
//  main.c
//  BaekJun Algorithm 51(1110, 더하기 사이클)
//  https://www.acmicpc.net/problem/1110
//  Created by hyungwook on 2021/03/29.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n, fix;
    int count = 0;
    
    scanf("%d", &n);
    fix = n;
    
    if(n < 10 && n > 0)
    {
        n *= 11;
        count++;
        while(1)
        {
            int x = ((n / 10) + (n % 10)) % 10;
            
            n = x + (n % 10) * 10;
            count++;
            if(n == fix)
                break;
        }
    }
    
    else if(n == 0)
    {
        printf("1\n");
        return 0;
    }
    
    else
    {
        while(1)
        {
            int x = ((n / 10) + (n % 10)) % 10;
            
            n = x + (n % 10) * 10;
            count++;
            if(n == fix)
                break;
        }
    }
    
    printf("%d\n", count);

    return 0;
}
