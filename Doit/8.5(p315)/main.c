//
//  main.c
//  8.5(p315)
//
//  Created by hyungwook on 2021/03/13.
//

#include <stdio.h>

char *str_chr(char *s, int c)
{
    c = (char)c;
    while(*s != '\0')
    {
        if(*s == c)
            return s;
        s++;
    }
    return NULL;
}

int main(void)
{
    char str[64];
    char tmp[64];
    int ch;

    printf("문자열 : ");
    scanf("%s", str);

    printf("검색할 문자 : ");
    scanf("%s", tmp);
    ch = tmp[0];
    
    char *idx = str_chr(str, ch);

    if (idx == NULL)
        printf("문자 '%c'는 문자열에 없습니다.\n", ch);
    else
        printf("문자 '%c'는 %ld 번째 있습니다.\n", ch, idx - str + 1);

    return 0;
}
