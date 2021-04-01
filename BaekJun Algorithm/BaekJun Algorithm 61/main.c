//
//  main.c
//  BaekJun Algorithm 61(3053, 택시 기하학)
//  https://www.acmicpc.net/problem/3053
//  Created by hyungwook on 2021/04/01.
//

#include <stdio.h>
#define PI 3.14159265358929

int main(int argc, const char * argv[]) {
    // insert code here...
    int r;
    
    scanf("%d", &r);
    
    printf("%.6f\n", PI * r * r);
    printf("%.6f\n", 2.0 * r * r);
    
    return 0;
}
