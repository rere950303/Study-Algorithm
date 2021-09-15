//
//  main.c
//  6.11(p216)
//
//  Created by hyungwook on 2021/03/12.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void BinaryInsertionSort(int a[], int n)
{
    for(int i = 1; i < n; i++)
    {
        int key = a[i];
        int pl = 0;
        int pr = i - 1;
        int pc = 0;
        int pd = 0;
        
        do {
            pc = (pl + pr) / 2;
        
            if(a[i] == a[pc])
            {
                break;
            }
            
            else if(a[i] > a[pc])
            {
                pl = pc + 1;
            }
            
            else
            {
                pr = pc - 1;
            }
        } while(pl <= pr);
        
        pd = (pl <= pr) ? pc + 1 : pr + 1;
        
        memmove(&a[pd + 1], &a[pd], sizeof(int) * (i - pd));

        a[pd] = key;
    }
}

int main(void)
{
    int i, nx;
    int *x;
    puts("단순 삽입 정렬");
    printf("요소 개수 : ");
    scanf("%d", &nx);
    x = calloc(nx, sizeof(int));

    for (i = 0; i < nx; i++) {
        printf("x[%d] : ", i);
        scanf("%d", &x[i]);
    }

    BinaryInsertionSort(x, nx);
    
    puts("오름차순으로 정렬했습니다.");
    for (i = 0; i < nx; i++)
        printf("x[%d] = %d\n", i, x[i]);
    
    free(x);
    
    return 0;
}
