//
//  main.c
//  BaekJun Algorithm 6(단어 공부, 1157)
//  https://www.acmicpc.net/problem/1157
//  Created by hyungwook on 2021/02/27.
//

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    char s[1000001] = "";
    int a[26] = {0};
    int count = 0;
    int result = 0;
    int max = 0;
    
    scanf("%s", s);
    
    int len = strlen(s);

    for(int i = 0; i < len; i++)
    {
        if(s[i] > 90)
            (a[s[i] - 97])++;
        else
            (a[s[i] - 65])++;
    }
    
    for(int i = 0; i < 26; i++)
    {
        if(a[i] > max)
        {
            max = a[i];
            result = i;
        }
    }
    
    for(int i = 0; i < 26; i++)
    {
        if(a[i] == max)
        {
            count++;
        }
    }

    if(count > 1)
        printf("%c\n", '?');
    else
        printf("%c\n", result + 65);

    return 0;
}
