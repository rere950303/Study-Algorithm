//
//  main.c
//  BaekJun Algorithm 53(1978, 소수 찾기)
//  https://www.acmicpc.net/problem/1978
//  Created by hyungwook on 2021/03/29.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int prime;
    int count = 0;
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        int flag = 0;
        
        scanf("%d", &prime);
        for(int j = 2; j * j <= prime; j++)
        {
            if(prime % j == 0)
            {
                flag = 1;
                break;
            }
        }
        if(flag == 0 && prime != 1)
            count++;
    }
    
    printf("%d\n", count);
 
    return 0;
}
