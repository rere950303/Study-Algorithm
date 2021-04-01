//
//  main.c
//  BaekJun Algorithm 60(4153, 직각삼각형)
//  https://www.acmicpc.net/problem/4153
//  Created by hyungwook on 2021/04/01.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    
    while(1)
    {
        int a[3];
        
        scanf("%d %d %d", &a[0], &a[1], &a[2]);
        if(a[0] == 0)
            break;
        
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 2 - i; j++)
            {
                if(a[j + 1] <= a[j])
                {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        
        if((a[0] * a[0] + a[1] * a[1]) == (a[2] * a[2]))
        {
            printf("right\n");
        }
        else
        {
            printf("wrong\n");
        }
    }
 
    return 0;
}
