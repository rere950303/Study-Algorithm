//
//  main.c
//  BaekJun Algorithm 56(11653, 소인수분해)
//  https://www.acmicpc.net/problem/11653
//  Created by hyungwook on 2021/03/31.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int ptr = 0;
    int prime[100000];
    
    scanf("%d", &n);
    
    prime[ptr++] = 2;
    prime[ptr++] = 3;
        
    for(int i = 5; i <= 10000000; i += 2)
    {
        int flag = 0;
        for(int j = 1; prime[j] * prime[j] <= i; j++)
        {
            if(i % prime[j] == 0)
            {
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            prime[ptr++] = i;
    }
    
    while(n != 1)
    {
        for(int i = 0; i < ptr; i++)
        {
            if(n % prime[i] == 0)
            {
                printf("%d\n", prime[i]);
                n /= prime[i];
                break;
            }
        }
    }

    return 0;
}
