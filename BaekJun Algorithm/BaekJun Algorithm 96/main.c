//
//  main.c
//  BaekJun Algorithm 96(2884, 알람 시계)
//  https://www.acmicpc.net/problem/2884
//  Created by hyungwook on 2021/05/16.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int h, m;
    
    scanf("%d %d", &h, &m);
    
    if(m - 45 < 0)
    {
        if(h == 0)
        {
            printf("23 %d\n", m - 45 + 60);
        }
        else
        {
            printf("%d %d\n", h - 1, m - 45 + 60);
        }
    }
    
    else
    {
        printf("%d %d\n", h, m - 45);
    }
 
    return 0;
}
