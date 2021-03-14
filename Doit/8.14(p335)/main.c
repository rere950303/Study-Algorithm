//
//  main.c
//  8.14(p335)
//
//  Created by hyungwook on 2021/03/14.
//

#include <stdio.h>
#include <string.h>

char *str_rstr(const char *s1, const char *s2)
{
    int len = strlen(s2);
    char *Index = NULL;
    const char *p1 = s1;
    const char *p2 = s2;

    while(*p1 != '\0')
    {
        if(*p1 == *p2)
        {
            p1++;
            p2++;
            if(*p2 == '\0')
            {
                Index = p1 - len;
                p2 = s2;
                p1 = p1 - len + 1;
            }
        }
        else
        {
            p2 = s2;
            p1 = p1 - (p2 - s2) + 1;
        }
    }
    
    return Index;
}

int main(void)
{
    char s1[256], s2[256];
    char *p;

    puts("str_rstr 함수");

    printf("텍스트: ");
    scanf("%s", s1);

    printf("패턴: ");
    scanf("%s", s2);

    p = str_rstr(s1, s2);

    if (p == NULL)
        printf("텍스트에 패턴이 없습니다.\n");
    else {
        int ofs = p - s1;
        printf("\n%s\n", s1);
        printf("%*s|\n", ofs, "");
        printf("%*s%s\n", ofs, "", s2);
    }

    return 0;
}
