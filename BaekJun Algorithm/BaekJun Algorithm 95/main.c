//
//  main.c
//  BaekJun Algorithm 95
//
//  Created by hyungwook on 2021/05/16.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int a, b;
    double c;
    
    scanf("%d %d", &a, &b);
    c = (double)a / b;
    
    printf("%.9f\n", c);
    
    return 0;
}
