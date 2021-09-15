//
//  main.c
//  BaekJun Algorithm 57(4948, 베르트랑 공준)
//  https://www.acmicpc.net/problem/4948
//  Created by hyungwook on 2021/03/31.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int idx;
    int ptr = 0;
    int prime[100000];
    
    prime[ptr++] = 2;
    prime[ptr++] = 3;
        
    while(1)
    {
        ptr = 2;
        
        scanf("%d", &n);
        if(n == 0)
            break;
        
        for(int i = 5; i <= 2 * n; i += 2)
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
            if(n < prime[i])
            {
                idx = i;
                break;
            }
        }
        
        if(n == 1)
        {
            printf("1\n");
        }
        else
        {
            printf("%d\n", ptr - idx);
        }
    }
  
    return 0;
}
