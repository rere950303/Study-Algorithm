//
//  main.c
//  BaekJun Algorithm 26(1193, 분수찾기)
//  https://www.acmicpc.net/problem/1193
//  Created by hyungwook on 2021/03/20.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    int sum = 0;
    int count = 0;
    int k = 1;
    
    scanf("%d", &n);
    
    while(n > sum)
    {
        sum += k;
        k++;
        count++;
    }
    
    if(count % 2 == 0)
    {
        k = 1;
        sum = 0;
        for(int i = 0; i < count - 1; i++)
        {
            sum += k;
            k++;
        }
        printf("%d/%d\n", n - sum, (count + 1) - (n - sum));
    }
    
    else
    {
        k = 1;
        sum = 0;
        for(int i = 0; i < count - 1; i++)
        {
            sum += k;
            k++;
        }
        printf("%d/%d\n", (count + 1) - (n - sum), n - sum);
    }

    return 0;
}
