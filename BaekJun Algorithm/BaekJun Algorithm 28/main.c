//
//  main.c
//  BaekJun Algorithm 28(2839, 설탕 배달)
//  https://www.acmicpc.net/problem/2839
//  Created by hyungwook on 2021/03/21.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    
    scanf("%d", &n);
    
    int five = n / 5;
    int remainder = n % 5;
    
    while(remainder % 3 != 0 && five >= 0)
    {
        five--;
        remainder = n - (5 * five);
    }
    
    if(five < 0)
    {
        printf("-1\n");
    }
    else
    {
        printf("%d\n", five + remainder / 3);
    }
    
    return 0;
}
