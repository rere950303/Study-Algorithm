//
//  main.c
//  BaekJun Algorithm 55
//
//  Created by hyungwook on 2021/03/30.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int m, n;
    int sum = 0;
    int idx = 0;
    int ptr = 0;
    int prime[10000];
    
    prime[ptr++] = 2;
    prime[ptr++] = 3;
    
    scanf("%d", &m);
    scanf("%d", &n);
    
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
    
    int i = 0;
    
    for(; i < ptr; i++)
    {
        if(m <= prime[i])
        {
            idx = i;
            break;
        }
    }
    
    if(n == 2)
    {
        printf("2\n2\n");
    }
    else if(n == 1)
    {
        printf("-1\n");
    }
    else
    {
        for(int j = idx; j < ptr; j++)
        {
            sum += prime[j];
        }
        if(i == ptr)
            printf("-1\n");
        else
            printf("%d\n%d\n", sum, prime[idx]);
    }

    return 0;
}
