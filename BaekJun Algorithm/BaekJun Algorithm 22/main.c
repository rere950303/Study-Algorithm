//
//  main.c
//  BaekJun Algorithm 22
//
//  Created by hyungwook on 2021/03/20.
//

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    char s[101];
    int alpha[26];
    memset(alpha, -1, 26 * sizeof(int));
    
    scanf("%s", s);
    
    int len = strlen(s);
    
    for(int i = 0; i < len; i++)
    {
        char *ptr = strchr(s, s[i]);
        alpha[s[i] - 'a'] = ptr - s;
    }
    
    for(int i = 0; i < 26; i++)
    {
        printf("%d ", alpha[i]);
    }
    printf("\n");
    
    return 0;
}
