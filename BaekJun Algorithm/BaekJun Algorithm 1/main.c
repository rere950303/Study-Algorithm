//
//  main.c
//  BaekJun Algorithm 1(숫자의 합, 11720번)
//  https://www.acmicpc.net/problem/11720

//  Created by hyungwook on 2021/02/27.
//

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int N = 0;
    int a[100] = {0};
    int result = 0;
    char s[101] = "";
    
    scanf("%d", &N);
    scanf("%s", s);
    
    for(int i = 0; i < N; i++)
    {
        a[i] = s[i] - '0';
    }
    
    for(int i = 0; i < N; i++)
    {
        result += a[i];
    }

    printf("%d\n", result);

    return 0;
}
