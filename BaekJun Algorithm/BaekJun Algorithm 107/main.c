//
//  main.c
//  BaekJun Algorithm 107(7568, 덩치)
//  https://www.acmicpc.net/problem/7568
//  Created by hyungwook on 2021/05/24.
//

#include <stdio.h>

typedef struct person {
    int x;
    int y;
} Person;

Person list[50];

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%d %d", &list[i].x, &list[i].y);
    }
    
    int count;
    
    for(int i = 0; i < n; i++)
    {
        count = 1;
        for(int j = 0; j < n; j++)
        {
            if(list[i].x < list[j].x && list[i].y < list[j].y)
            {
                count++;
            }
        }
        printf("%d ", count);
    }
    
    return 0;
}
