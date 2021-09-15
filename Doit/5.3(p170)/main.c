//
//  main.c
//  5.3(p170)
//
//  Created by hyungwook on 2021/03/10.
//

#include <stdio.h>
#include <stdlib.h>

int gcd(int x, int y)
{
    while(y != 0)
    {
        int temp = x;
        x = y;
        y = temp % y;
    }
    
    return x;
}

int gcd_array(const int a[], int n)
{
    int FinalValue = gcd(a[0], a[1]);

    for(int i = 0; i < n - 2; i++)
    {
        FinalValue = gcd(FinalValue, a[i + 2]);
    }
    
    return FinalValue;
}

int main(void)
{
    int i, nx;
    int *x;

    printf("요솟수 : ");
    scanf("%d", &nx);
    x = calloc(nx, sizeof(int));

    for (i = 0; i < nx; i++)
    {
        printf("x[%d] : ", i);
        scanf("%d", &x[i]);
    }

    printf("최대 공약수는 %d입니다.\n", gcd_array(x, nx));

    free(x);

    return 0;
}
