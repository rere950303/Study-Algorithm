//
//  main.c
//  BaekJun Algorithm 62(3009, 네 번째 점)
//  https://www.acmicpc.net/problem/3009
//  Created by hyungwook on 2021/04/02.
//

#include <stdio.h>

typedef struct {
    int x;
    int y;
} Point;

Point list[4];

int main(int argc, const char * argv[]) {
    // insert code here...
 
    for(int i = 0; i < 3; i++)
    {
        scanf("%d %d", &list[i].x, &list[i].y);
    }
    
    if(list[0].x == list[1].x)
        list[3].x = list[2].x;
    else if(list[1].x == list[2].x)
        list[3].x = list[0].x;
    else if(list[0].x == list[2].x)
        list[3].x = list[1].x;
    
    if(list[0].y == list[1].y)
        list[3].y = list[2].y;
    else if(list[1].y == list[2].y)
        list[3].y = list[0].y;
    else if(list[0].y == list[2].y)
        list[3].y = list[1].y;
    
    printf("%d %d\n", list[3].x, list[3].y);

    return 0;
}
