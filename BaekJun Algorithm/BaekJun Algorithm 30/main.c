//
//  main.c
//  BaekJun Algorithm 30(1011, Fly me to the Alpha Centauri)
//  https://www.acmicpc.net/problem/1011
//  Created by hyungwook on 2021/03/21.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct __point {
    long long x;
    long long y;
} Point;

Point *list[10];

int main(int argc, const char * argv[]) {
    // insert code here...
    int N;
    
    scanf("%d", &N);
    
    for(int i = 0; i < N; i++)
    {
        list[i] = calloc(1, sizeof(Point));
        scanf("%lld %lld", &list[i]->x, &list[i]->y);
    }
    
    for(int i = 0; i < N; i++)
    {
        long long n = 1;
        long long len = list[i]->y - list[i]->x;
        
        while(1)
        {
            if(len >= n * n - n + 1 && len <= n * n + n)
            {
                if(len <= n * n)
                {
                    printf("%lld\n", 2 * n - 1);
                    break;
                }
                else
                {
                    printf("%lld\n", 2 * n);
                    break;
                }
            }
            
            n++;
        }
    }
    
    return 0;
}
