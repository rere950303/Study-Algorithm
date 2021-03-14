//
//  main.c
//  8.3(p311)
//
//  Created by hyungwook on 2021/03/13.
//

#include <stdio.h>
#define swap(type, a, b) do {type temp = a; a = b; b = temp;} while(0)

void swap_str(char *x, char *y)
{
    do {
        swap(char, *x, *y);
        x++;
        y++;
    } while(*x != '\0' || *y != '\0');
}

int main(void)
{
    char s1[128], s2[128];

    printf("문자열 S1 :");    scanf("%s", s1);
    printf("문자열 S2 :");    scanf("%s", s2);

    swap_str(s1, s2);

    printf("두 문자열을 교환했습니다.\n");
    printf("문자열 S1 : %s\n", s1);
    printf("문자열 S2 : %s\n", s2);

    return 0;
}
