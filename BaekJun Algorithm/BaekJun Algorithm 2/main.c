//
//  main.c
//  BaekJun Algorithm 2(문자열 반복, 2675번)
//  https://www.acmicpc.net/problem/2675
//  Created by hyungwook on 2021/02/27.
//

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int T = 0;
    char s[21] = "";
    int n = 0;
    
    scanf("%d", &T);
    
    for(int i = 0; i < T; i++)
    {
        scanf("%d %s", &n, s);
        for(int j = 0; j < strlen(s); j++)
        {
            for(int k = 0; k < n; k++)
            {
                printf("%c", s[j]);
            }
        }
        printf("\n");
    }

    return 0;
}
