//
//  main.c
//  8.13(p335)
//
//  Created by hyungwook on 2021/03/13.
//

#include <stdio.h>

char *str_str(const char *s1, const char *s2)
{
    const char *p1 = s1;
    const char *p2 = s2;
    
    while(*p1 != '\0' && *p2 != '\0')
    {
        if(*p1 == *p2)
        {
            p1++;
            p2++;
        }
        
        else
        {
            p2 = s2;
            p1 = p1 - (p2 - s2) + 1;
        }
    }
    
    if(*p2 == '\0')
        return (char *)(p1 - (p2 - s2));
    else
        return NULL;
}

int main(void)
{
    char s1[256], s2[256];
    char *p;

    puts("strstr 함수");

    printf("텍스트: ");
    scanf("%s", s1);

    printf("패턴: ");
    scanf("%s", s2);

    p = str_str(s1, s2);

    if (p == NULL)
        printf("텍스트에 패턴이 없습니다.\n");
    else
    {
        int ofs = p - s1;
        printf("\n%s\n", s1);
        printf("%*s|\n", ofs, "");
        printf("%*s%s\n", ofs, "", s2);
    }

    return 0;
}
