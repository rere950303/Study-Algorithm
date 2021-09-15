//
//  main.c
//  8.7(p319)
//
//  Created by hyungwook on 2021/03/13.
//

#include <stdio.h>

int str_ncmp(const char *s1, const char *s2, size_t n)
{
    int i = 0;
    
    while(i < n && *s2 != '\0')
    {
        if(*s1 == *s2)
        {
            i++;
            s1++;
            s2++;
        }
        else
            break;
    }
    
    if(i == 3)
        return 0;
    else
        return *s1 - *s2;
}

int main(void)
{
    char st[128];

    puts("\"STRING\"의 처음 세 문자와 비교합니다.");
    puts("\"XXXX\"이면 종료합니다.");

    while (1) {
        printf("문자열：");
        scanf("%s", st);

        if (str_ncmp("XXXX", st, 3) == 0)
            break;
        printf("str_ncmp(\"STRING\", st, 3) = %d\n", str_ncmp("STRING", st, 3));
    }

    return 0;
}
