//
//  main.c
//  BaekJun Algorithm 109(1436, 영화감독 숌)
//  https://www.acmicpc.net/problem/1436
//  Created by hyungwook on 2021/05/24.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int idx = 0;
    int flag = 666;
    
    scanf("%d", &n);
    
    while(1)
    {
        int temp = flag;
        
        while(temp)
        {
            if(temp % 1000 == 666)
            {
                idx++;
                break;
            }
            temp /= 10;
        }
        if(idx == n)
        {
            break;
        }
        
        flag++;
    }
    
    printf("%d\n", flag);

    return 0;
}
