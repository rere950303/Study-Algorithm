//
//  main.c
//  BaekJun Algorithm 112(셀프 넘버, 4673)
//  https://www.acmicpc.net/problem/4673
//  Created by hyungwook on 2021/06/07.
//

#include <stdio.h>
#include <stdbool.h>

bool arr[10001];

int isSelfNum(int n)
{
    int sum = n;
    
    while(n > 0)
    {
        sum += n % 10;
        n /= 10;
    }
    
    return sum;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    for(int i = 1; i <= 10000; i++)
    {
        int index = isSelfNum(i);
        
        if(index <= 10000)
        {
            arr[index] = true;
        }
    }
    
    for(int i = 1; i <= 10000; i++)
    {
        if(arr[i] == false)
            printf("%d\n", i);
    }

    return 0;
}
