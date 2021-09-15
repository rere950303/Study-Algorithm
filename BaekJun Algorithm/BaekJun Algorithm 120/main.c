//
//  main.c
//  BaekJun Algorithm 120(동전 0, 11047)
//  https://www.acmicpc.net/problem/11047
//  Created by hyungwook on 2021/06/22.
//

#include <stdio.h>
#include <stdbool.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n, k;
    int value[10];
    int pc = 0;
    int count = 0;
    
    scanf("%d %d", &n, &k);
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &value[i]);
    }
    
    for(int i = n - 1; i >= 0; i--)
    {
        if(k >= value[i])
        {
            pc = i;
            break;
        }
    }
    
    while(true)
    {
        count += k / value[pc];
        k %= value[pc];
        pc--;
        if(k == 0)
            break;
    }
    
    printf("%d\n", count);

    return 0;
}
