//
//  main.c
//  8.6(p315)
//
//  Created by hyungwook on 2021/03/13.
//

#include <stdio.h>
#include <string.h>

char *str_rchr(const char *s, int c)
{
    c = (char)c;
    char *Point = NULL;
    
    while(*s != '\0')
    {
        if(*s == c)
            Point = s;
        s++;
    }
    
    return Point;
}

int main(void)
{
    char str[64];
    char tmp[64];
    int  ch;

    printf("문자열：");
    scanf("%s", str);

    printf("검색：");
    scanf("%s", tmp);
    ch = tmp[0];
    
    char *idx = str_rchr(str, ch);

    if (idx == NULL)
        printf("문자 '%c'는 문자열 안에 없습니다.\n", ch);
    else
        printf("문자 '%c'는 %d번째에 있습니다.\n", ch, idx - str + 1);

    return 0;
}
