//
//  main.c
//  6.20(p246)
//
//  Created by hyungwook on 2021/03/12.
//

#include <stdio.h>
#include <stdlib.h>

void swap(char *x, char *y, size_t n)
{
    for(int i = 0; i < n; i++, x++, y++)
    {
        char temp = *x;
        *x = *y;
        *y = temp;
    }
}

int int_cmp(const int *a, const int *b)
{
    return *a < *b ? -1 : *a > *b ? 1 : 0;
}

void q_sort(void *base, size_t nmnmb, size_t size, int (*compare)(const void *, const void *))
{
    size_t pl = 0;
    size_t pr = nmnmb - 1;
    char *x = &((char *)base)[((pl + pr) / 2) * size];

        
    do {
        while (compare(&((char *)base)[pl * size], x) < 0)
            pl++;
        while (compare(&((char *)base)[pr * size], x) > 0)
            pr--;

        if (pl <= pr)
        {
            swap(&((char *)base)[pl * size], &((char *)base)[pr * size], size);
            pl++;
            if(pr == 0)
            {
                goto QuickRight;
            }
            pr--;
        }
    } while (pl <= pr);

    if (0 < pr)
        q_sort(base, pr + 1, size, compare);
    
QuickRight:
    if (pl < nmnmb - 1)
        q_sort(&((char *)base)[pl * size], nmnmb - pl, size, compare);
}

int main(void)
{
    int i, nx;
    int *x;
    printf("qsort에 의한 정렬\n");
    printf("요소 개수 : ");
    scanf("%d", &nx);
    
    x = calloc(nx, sizeof(int));
    
    for (i = 0; i < nx; i++)
    {
        printf("x[%d] : ", i);
        scanf("%d", &x[i]);
    }
    
    q_sort(x, nx, sizeof(int), (int(*)(const void *, const void *))int_cmp);
    
    puts("오름차순으로 정렬했습니다.");
    for (i = 0; i < nx; i++)
        printf("x[%d] = %d\n", i, x[i]);
    
    free(x);
    
    return 0;
}
