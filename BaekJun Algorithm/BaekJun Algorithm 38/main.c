//
//  main.c
//  BaekJun Algorithm 39(9375, 패션왕 신해빈)
//  https://www.acmicpc.net/problem/9375
//  Created by hyungwook on 2021/03/25.
//

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct __types {
    int n;
    char type[21];
} Types;

Types list[30];

int main(int argc, const char * argv[]) {
    // insert code here...
    int t, n;
    char name[21];
    
    scanf("%d", &t);
    
    for(int i = 0; i < t; i++)
    {
        scanf("%d", &n);
        int count = 1;
        
        for(int j = 0; j < 30; j++)
        {
            list[j].n = 0;
        }
        
        for(int j = 0; j < n; j++)
        {
            int k = 0;
            
            scanf("%s %s", name, list[j].type);
            for(; k < j; k++)
            {
                if(strcmp(list[j].type, list[k].type) == 0)
                {
                    list[k].n++;
                    break;
                }
            }
            if(k == j)
                list[j].n++;
        }
        
        for(int j = 0; j < 30; j++)
        {
            if(list[j].n != 0)
                count *= (list[j].n + 1);
        }
        
        printf("%d\n", count - 1);
    }
        
    return 0;
}
