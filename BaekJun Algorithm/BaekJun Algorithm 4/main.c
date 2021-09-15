//
//  main.c
//  BaekJun Algorithm 4(크로아티아 알파벳, 2941)
//  https://www.acmicpc.net/problem/2941
//  Created by hyungwook on 2021/02/27.
//

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    char s[101] = "";
    int count[8] = {0};
    char *ptr[8] = {NULL};
    char *p[8] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    int sum = 0;
    int result1 = 0;
    int result2 = 0;

    scanf("%s", s);
    
    for(int i = 0; i < 8; i++)
    {
        ptr[i] = strstr(s, p[i]);
        while(ptr[i] != NULL)
        {
            (count[i])++;
            ptr[i] = strstr(ptr[i] + 1, p[i]);
        }
    }
    
    count[7] -= count[2];
    
    for(int i = 0; i < 8; i++)
    {
        sum += count[i];
    }
    
    
    for(int i = 0; i < 2; i++)
    {
        result1 += (2 * count[i]);
    }
    
    for(int i = 3; i < 8; i++)
    {
        result1 += (2 * count[i]);
    }
    
    result1 += (3 * count[2]);
    result2 = strlen(s) - result1;
    
    printf("%d\n", sum + result2);

    return 0;
}
