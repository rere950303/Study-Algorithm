//
//  main.c
//  BaekJun Algorithm 27(10250, ACM 호텔)
//  https://www.acmicpc.net/problem/10250
//  Created by hyungwook on 2021/03/20.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct __hotel {
    int h;
    int w;
    int n;
} Hotel;

Hotel *list[100];

int main(int argc, const char * argv[]) {
    // insert code here...
    int num;
    scanf("%d", &num);
    
    for(int i = 0; i < num; i++)
    {
        list[i] = calloc(1, sizeof(Hotel));
        scanf("%d %d %d", &list[i]->h, &list[i]->w, &list[i]->n);
    }
    
    for(int i = 0 ;i < num; i++)
    {
        int height = list[i]->n % list[i]->h;
        int width = list[i]->n / list[i]->h;
        if(height == 0)
        {
            printf("%d\n", list[i]->h * 100 + width);
        }
        else
        {
            printf("%d\n", height * 100 + width + 1);
        }
    }
 
    return 0;
}
