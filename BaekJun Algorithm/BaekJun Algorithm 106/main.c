//
//  main.c
//  BaekJun Algorithm 106(2231, 분해합)
//  https://www.acmicpc.net/problem/2231
//  Created by hyungwook on 2021/05/21.
//

#include <stdio.h>
#include <math.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int count = 0;
    int sum = 0;
    int flag = 0;
    
    scanf("%d", &n);
    
    int temp = n;
    
    while(temp > 0)
    {
        temp /= 10;
        count++;
    }
    
    int i;
    
    if(n - 9 * count < 0)
    {
        i = 0;
    }
    
    else
    {
        i = n - 9 * count;
    }
    
    for(i; i < n; i++)
    {
        int tmp = i;
        sum = i;
        for(int j = 0; j < count; j++)
        {
            sum += tmp % 10;
            tmp /= 10;
        }
        if(sum == n)
        {
            printf("%d\n", i);
            flag = 1;
            break;
        }
    }
    
    if(flag == 0)
        printf("0\n");
    return 0;
}
