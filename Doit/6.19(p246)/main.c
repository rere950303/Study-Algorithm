//
//  main.c
//  6.19(p246)
//
//  Created by hyungwook on 2021/03/12.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int char_cmp(const char **a, const char **b)
{
    return strcmp(*a, *b);
}

int main(void)
{
    char a[][7] = {"LISP", "C", "Ada", "Pascal"};
    char *p[] = {"LISP", "C", "Ada", "Pascal"};
    char *p1[4];
    
    for(int i = 0; i < 4; i++)
    {
        p1[i] = a[i];
    }

    qsort(p1,
        4,
        sizeof(void *),
        (int(*)(const void *, const void *))char_cmp
    );
    
    qsort(p,
        4,
        sizeof(void *),
        (int(*)(const void *, const void *))char_cmp
    );

    puts("오름차순으로 정렬했습니다.");
    
    printf("char a[][7]\n");
    for (int i = 0; i < 4; i++)
        printf("%s\n", p1[i]);
    
    printf("char *p[]\n");
    for (int i = 0; i < 4; i++)
        printf("%s\n", p[i]);
        
    return 0;
}
