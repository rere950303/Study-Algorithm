//
//  main.c
//  8.2(p311)
//
//  Created by hyungwook on 2021/03/13.
//

#include <stdio.h>

#define swap_ptr(type, s1, s2) do {type temp = s1; s1 = s2; s2 = temp;} while(0)

int main(void)
{
    char *s1 = "ABCD";
    char *s2 = "EFGH";

    printf("포인터 s1은 \"%s\"를 가리킵니다.\n", s1);
    printf("포인터 s2는 \"%s\"를 가리킵니다.\n", s2);

    swap_ptr(char *, s1, s2);

    puts("\n포인터 s1과 s2의 값을 서로 교환했습니다.\n");

    printf("포인터 s1은 \"%s\"를 가리킵니다.\n", s1);
    printf("포인터 s2는 \"%s\"를 가리킵니다.\n", s2);

    return 0;
}
