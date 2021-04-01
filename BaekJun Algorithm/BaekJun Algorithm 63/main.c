//
//  main.c
//  BaekJun Algorithm 63(1002, 터렛)
//  https://www.acmicpc.net/problem/1002
//  Created by hyungwook on 2021/04/02.
//

#include <stdio.h>
#include <math.h>

typedef struct {
    int x;
    int y;
    int r;
} Point;

Point list[2];

int main(int argc, const char * argv[]) {
    // insert code here...
    int t;
    
    scanf("%d", &t);
    
    for(int i = 0; i < t; i++)
    {
        scanf("%d %d %d %d %d %d", &list[0].x, &list[0].y, &list[0].r, &list[1].x, &list[1].y, &list[1].r);
        
        
        int r_sub = list[0].r - list[1].r;
        int r_sum = list[0].r + list[1].r;
        float distance = sqrt(pow(list[0].x - list[1].x, 2) + pow(list[0].y - list[1].y, 2));
        
        if(r_sub < 0)
            r_sub = -r_sub;
        
        if(r_sum == distance)
            printf("1\n");
        else if((distance == 0) && (list[0].r == list[1].r))
            printf("-1\n");
        else if((distance == 0) && (list[0].r != list[1].r))
            printf("0\n");
        else if((r_sub < distance) && (r_sum > distance))
            printf("2\n");
        else if((r_sub == distance) && (distance != 0))
            printf("1\n");
        else
            printf("0\n");
    }
    
    return 0;
}
