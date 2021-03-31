//
//  main.c
//  BaekJun Algorithm 58(9020, 골드바흐의 추측)
//  https://www.acmicpc.net/problem/9020
//  Created by hyungwook on 2021/04/01.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n, t;
    int ridx;
    int ptr = 0;
    int prime[10000];
    
    scanf("%d", &t);
    
    prime[ptr++] = 2;
    prime[ptr++] = 3;
    
    for(int i = 5; i <= 10000; i += 2)
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
 
    for(int i = 0; i < t; i++)
    {
        int lidx = 0;

        scanf("%d", &n);
        
        if(n == 4)
            printf("2 2\n");
        else
        {
            while(1)
            {
                while(prime[lidx] < n / 2)
                {
                    lidx++;
                }
                
                int x = lidx - 1;
                
                if(prime[lidx] == n / 2)
                {
                    printf("%d %d\n", prime[lidx], prime[lidx]);
                    break;
                }
                else
                {
                    while(x >= 0)
                    {
                        int j = lidx;
                        int ridx = x;

                        for(; j < ptr; j++)
                        {
                            if(prime[j] == n - prime[x])
                            {
                                ridx = j;
                                break;
                            }
                        }
                        if(ridx != x)
                        {
                            printf("%d %d\n", prime[x], prime[ridx]);
                            break;
                        }
                        else
                        {
                            x--;
                        }
                    }
                }
                break;
            }
        }
    }
 
    return 0;
}
