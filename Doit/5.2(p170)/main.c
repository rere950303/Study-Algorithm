//
//  main.c
//  5.2(p170)
//
//  Created by hyungwook on 2021/03/10.
//

#include <stdio.h>

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

int main(void)
{
    int x, y;

    puts("두 정수의 최대 공약수를 구합니다.");

    printf("정수를 입력하세요. : ");
    scanf("%d", &x);

    printf("정수를 입력하세요. : ");
    scanf("%d", &y);

    printf("최대 공약수는 %d입니다.\n", gcd(x, y));

    return 0;
}
