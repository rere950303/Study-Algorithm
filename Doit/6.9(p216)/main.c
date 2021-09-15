//
//  main.c
//  6.9(p216)
//
//  Created by hyungwook on 2021/03/11.
//

#include <stdio.h>
#include <stdlib.h>

void insertion(int a[], int n)
{
    int i, j;

    for (i = 1; i < n; i++)
    {
        int tmp = a[0] = a[i];
        for (j = i; a[j - 1] > tmp; j--)
            a[j] = a[j - 1];
        a[j] = tmp;
    }
}

int main(void)
{
    int i, nx;
    int *x;
    puts("단순 삽입 정렬");
    printf("요소 개수 : ");
    scanf("%d", &nx);
    x = calloc(nx + 1, sizeof(int));

    for (i = 1; i < nx + 1; i++) {
        printf("x[%d] : ", i - 1);
        scanf("%d", &x[i]);
    }

    insertion(x, nx + 1);
    
    puts("오름차순으로 정렬했습니다.");
    for (i = 1; i < nx + 1; i++)
        printf("x[%d] = %d\n", i - 1, x[i]);
    
    free(x);
    
    return 0;
}
