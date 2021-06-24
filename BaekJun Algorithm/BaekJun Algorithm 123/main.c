//
//  main.c
//  BaekJun Algorithm 123(주유소, 13305)
//  https://www.acmicpc.net/problem/13305
//  Created by hyungwook on 2021/06/24.
//

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    long *distance;
    long *cost;
    
    scanf("%d", &n);
    
    cost = calloc(n, sizeof(long));
    distance = calloc(n - 1, sizeof(long));
    
    for(int i = 0; i < n - 1; i++)
    {
        scanf("%ld", &distance[i]);
    }
    for(int i = 0; i < n; i++)
    {
        scanf("%ld", &cost[i]);
    }
    
    long sum = 0;
    
    for(int i = 0; i < n - 1; i++)
    {
        long len = distance[i];
        int next = i + 1;
        
        while((cost[next] >= cost[i]) && (next < n - 1))
        {
            len += distance[next];
            next++;
        }
        
        sum += cost[i] * len;
        i = next - 1;
    }
    
    printf("%ld\n", sum);

    free(distance);
    free(cost);
    
    return 0;
}
