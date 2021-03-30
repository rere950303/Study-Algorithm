//
//  main.c
//  BaekJun Algorithm 54(1929, 소수 구하기)
//  https://www.acmicpc.net/problem/1929
//  Created by hyungwook on 2021/03/29.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int m, n;
    int idx = 0;
    int ptr = 0;
    int prime[100000];
    
    prime[ptr++] = 2;
    prime[ptr++] = 3;
    
    scanf("%d %d", &m, &n);
    
    for(int i = 5; i <= n; i += 2)
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
    
    for(int i = 0; i < ptr; i++)
    {
        if(m <= prime[i])
        {
            idx = i;
            break;
        }
    }
    
    if(n == 2)
    {
        printf("2\n");
    }
    else
    {
        for(int i = idx; i < ptr; i++)
        {
            printf("%d\n", prime[i]);
        }
    }

    return 0;
}
