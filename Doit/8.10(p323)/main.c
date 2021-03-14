//
//  main.c
//  8.10(p323)
//
//  Created by hyungwook on 2021/03/13.
//

#include <stdio.h>
#include <string.h>

int bf_match(const char txt[], const char pat[])
{
    int pt = 0;
    int pp = 0;
    int Index = -1;
    int len = strlen(pat);

    while (txt[pt] != '\0')
    {
        if(txt[pt] == pat[pp])
        {
            pt++;
            pp++;
            
            if(pat[pp] == '\0')
            {
                Index = pt - pp;
                pp = 0;
                pt = pt - len + 1;
            }
        }
        
        else
        {
            pp = 0;
            pt = pt - pp + 1;
        }
    }
    
    return Index;
}

int main(void)
{
    int idx;
    char s1[256];
    char s2[256];

    puts("브루트-포스법");
    printf("텍스트 : ");
    scanf("%s", s1);
    printf("패턴 : ");
    scanf("%s", s2);
    
    idx = bf_match(s1, s2);
    if (idx == -1)
        puts("텍스트에 패턴이 없습니다.");
    else
        printf("%d번째 문자부터 match합니다.\n", idx + 1);
    
    return 0;
}
