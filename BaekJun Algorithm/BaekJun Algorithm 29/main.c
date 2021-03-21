//
//  main.c
//  BaekJun Algorithm 29(2869, 달팽이는 올라가고 싶다)
//  https://www.acmicpc.net/problem/2869
//  Created by hyungwook on 2021/03/21.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int a, b, v;
    
    scanf("%d %d %d", &a, &b, &v);
    
    int count = (v - a) / (a - b);
    int len_sum = (a - b) * count;
    
    while(1)
    {
        len_sum += a;
        if(len_sum < v)
        {
            len_sum -= b;
            count++;
        }
        else
        {
            count++;
            break;
        }
    }
    
    printf("%d\n", count);

    return 0;
}
