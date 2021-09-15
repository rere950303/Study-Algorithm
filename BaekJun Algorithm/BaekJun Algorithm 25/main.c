//
//  main.c
//  BaekJun Algorithm 25(2292 / 벌집)
//  https://www.acmicpc.net/problem/2292
//  Created by hyungwook on 2021/03/20.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int i = 7;
    int k = 2;
    int count = 2;
    
    scanf("%d", &n);
    
    if(n == 1)
    {
        printf("1\n");
        return 0;
    }
    else
    {
        while(n > i)
        {
            i = i + 6 * k;
            k++;
            count++;
        }
    }
    
    printf("%d\n", count);

    return 0;
}
