//
//  main.c
//  BaekJun Algorithm 5(단어의 개수, 1152)
//  acmicpc.net/problem/1152
//  Created by hyungwook on 2021/02/27.
//

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    char s[1000000] = "";
    int count = 0;
    
    scanf("%[^\n]s", s);
    
    char *ptr = strchr(s, ' ');
    
    while (ptr != NULL)
    {
        count++;
        ptr = strchr(ptr + 1, ' ');
    }
    
    if(s[0] == ' ')
        count--;
    if(s[strlen(s) - 1] == ' ')
        count--;

    printf("%d\n", count + 1);

    return 0;
}
