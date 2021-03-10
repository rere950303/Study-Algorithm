//
//  main.c
//  5.6(p182)
//
//  Created by hyungwook on 2021/03/10.
//

#include <stdio.h>

void move1(int no, char x, char y, char z)
{
    if (no > 1)
        move1(no - 1, x, z, y);
    printf("원반[%d]를 %c 기둥에서 %c 기둥으로 옮김\n", no, x, z);
    if (no > 1)
        move1(no - 1,y, x, z);
}
int main(void)
{
    int n;
    printf("하노이의 탑\n원반 개수 : ");
    scanf("%d", &n);

    move1(n, 'A', 'B', 'C');

    return 0;
}
