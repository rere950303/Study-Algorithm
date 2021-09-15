//
//  main.c
//  BaekJun Algorithm 23
//
//  Created by hyungwook on 2021/03/20.
//

#include <stdio.h>
#include <math.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int a, b;
    int reverse_a = 0;
    int reverse_b = 0;

    scanf("%d %d", &a, &b);
    
    for(int i = 1; i <= 3; i++)
    {
        reverse_a += (a % 10) * pow(10, 3 - i);
        a /= 10;
    }
    for(int i = 1; i <= 3; i++)
    {
        reverse_b += (b % 10) * pow(10, 3 - i);
        b /= 10;
    }
    
    printf("%d\n", reverse_a > reverse_b ? reverse_a : reverse_b);

    return 0;
}
