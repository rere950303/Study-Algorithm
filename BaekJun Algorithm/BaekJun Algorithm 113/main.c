//
//  main.c
//  BaekJun Algorithm 113(한수, 1065)
//  https://www.acmicpc.net/problem/1065
//  Created by hyungwook on 2021/06/07.
//

#include <stdio.h>
#include <stdbool.h>

bool isHansu(int n)
{
    int a[4];
    int index = 0;
    
    while(n > 0)
    {
        a[index++] = n % 10;
        n /= 10;
    }
    
    if(index == 1 || index == 2)
        return true;
    else if(index == 4)
        return false;
    else
    {
        if(a[0] - a[1] == a[1] - a[2])
            return true;
        else
            return  false;
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int count = 0;
    
    scanf("%d", &n);
    
    for(int i = 1; i <= n; i++)
    {
        bool x = isHansu(i);
        
        if(x == true)
        {
            count++;
        }
    }
    
    printf("%d\n", count);
 
    return 0;
}
