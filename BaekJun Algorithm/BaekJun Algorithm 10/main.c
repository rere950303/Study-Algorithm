//
//  main.c
//  BaekJun Algorithm 10
//
//  Created by hyungwook on 2021/03/06.
//

#include <stdio.h>
#include <stdlib.h>

struct Point2D {
    int x;
    int y;
};

int compare(const void *a, const void *b)
{
    struct Point2D *m, *n;
    
    m = (struct Point2D *)a;
    n = (struct Point2D *)b;
    if(m->x == n->x)
        return m->y > n->y;

    return (m->x) > (n->x);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n = 0;
    struct Point2D list[100000];
    
    scanf("%d", &n);
    
    for(int i = 0; i < n; i++)
    {
        scanf("%d %d", &list[i].x, &list[i].y);
    }
    
    qsort(list, n, sizeof(struct Point2D), compare);

    for(int i = 0; i < n; i++)
    {
        printf("%d %d\n", list[i].x, list[i].y);
    }

    return 0;
}
