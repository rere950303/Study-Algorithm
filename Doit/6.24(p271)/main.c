//
//  main.c
//  6.24(p271)
//
//  Created by hyungwook on 2021/03/13.
//

#include <stdio.h>
#include <stdlib.h>

void fsort(int a[], int n, int min, int max)
{
    int i;
    int *f = calloc(max + 1 - min, sizeof(int));
    int *b = calloc(n, sizeof(int));

    for (i = 0; i < max + 1 - min; i++)
    f[i] = 0;
    for (i = 0; i < n; i++)
    f[a[i] - min]++;
    for (i = 1; i <= max - min; i++)
    f[i] += f[i - 1];
    for (i = n - 1; i >= 0; i--)
    b[--f[a[i] - min]] = a[i];
    for (i = 0; i < n; i++)
    a[i] = b[i];
    
    free(b);
    free(f);
}

int main(void)
{
    int i, nx;
    int *x;
    int max, min;
    
    puts("도수 정렬");
    printf("요소 개수 : ");
    scanf("%d", &nx);
    x = calloc(nx, sizeof(int));
    
    printf("최댓값을 입력하세요: ");
    scanf("%d", &max);
    
    printf("최솟값을 입력하세요: ");
    scanf("%d", &min);
    
    for(int i = 0; i < nx; i++)
    {
        do {
            printf("x[%d]: ", i);
            scanf("%d", &x[i]);
        } while(x[i] > max || x[i] < min);
    }
    
    

    fsort(x, nx, min, max);
    
    puts("오름차순으로 정렬했습니다.");
    for (i = 0; i < nx; i++)
        printf("x[%d] = %d\n", i, x[i]);
    
    free(x);
    
    return 0;
}
