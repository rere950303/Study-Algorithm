//
//  main.c
//  BaekJun Algorithm 9(좌표 정렬하기, 11650)
//  https://www.acmicpc.net/problem/11650
//  Created by hyungwook on 2021/02/28.
//

#include <stdio.h>

struct point {
    int x;
    int y;
};

int main(int argc, const char * argv[]) {
    // insert code here...
    int n = 0;
    struct point list[100000];
    struct point a;
    
    scanf("%d", &n);
    
    for(int i = 0; i < n; i++)
    {
        scanf("%d %d", &list[i].x, &list[i].y);
    }
    
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n - 1 - i; j++)
        {
            if(list[i].x == list[i + 1].x)
            {
                if(list[i].y > list[i + 1].y)
                {
                    a = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = a;
                }
                
            }
            else if(list[i].x > list[i + 1].x)
            {
                a = list[i];
                list[i] = list[i + 1];
                list[i + 1] = a;
            }
        }
    }
    
    for(int i = 0; i < n; i++)
    {
        printf("%d %d\n", list[i].x, list[i].y);
    }

    return 0;
}
