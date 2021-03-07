//
//  main.c
//  3.9(p128)
//
//  Created by hyungwook on 2021/03/07.
//

#include <stdio.h>
#include <stdlib.h>

int *bsearchx(const void *key, const void *base, size_t nmemb, size_t size, int(*compare)(const void *, const void *))
{
    size_t pl = 0;
    size_t pr = nmemb - 1;
    
    char *x = (char *)base;
    
    do {
        size_t pc = (pl + pr) / 2;
        if(!compare((const void *)&x[pc * size], key))
        {
            for(; pc > pl; pc--)
            {
                if(compare((const void *)&x[(pc - 1) * size], key))
                    break;
            }
            return (&x[pc * size]);
        }
        else if(compare((const void *)&x[pc * size], key) == -1)
            pl = pc + 1;
        else
            pr = pc - 1;
    } while(pl <= pr);
    
    return NULL;
}

int int_cmp(const int *a, const int *b)
{
    if(*a < *b)
        return -1;
    else if(*a > *b)
        return 1;
    else
        return 0;
}


int main(int argc, const char * argv[]) {
    int i, nx, ky;
    int *x;
    int *p;
    
    puts("binsearch 함수를 사용하여 검색");
    printf("요솟수 : ");
    scanf("%d", &nx);
    
    x = calloc(nx, sizeof(int));
    
    printf("오름차순으로 입력하세요.\n");
    printf("x[0] : ");
    scanf("%d", &x[0]);
    for (i = 1; i < nx; i++)
    {
        do {
            printf("x[%d] : ", i);
            scanf("%d", &x[i]);
        } while (x[i] < x[i - 1]);
    }
    
    printf("검색 값 : ");
    scanf("%d", &ky);
    p = bsearchx(&ky,
                  x,
                  nx,
                  sizeof(int),
                  (int(*)(const void *, const void *))int_cmp
                  );
    
    if (p == NULL)
        puts("검색에 실패했습니다.");
    else
        printf("%d는 x[%d]에 있습니다.\n", ky, (int)(p - x));
    
    free(x);
    
    return 0;
}
