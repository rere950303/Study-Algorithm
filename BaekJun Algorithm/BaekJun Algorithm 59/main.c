//
//  main.c
//  BaekJun Algorithm 59(1085, 직사각형에서 탈출)
//  https://www.acmicpc.net/problem/1085
//  Created by hyungwook on 2021/04/01.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int x, y, w, h;
    
    scanf("%d %d %d %d", &x,&y,&w,&h);
    
    int xl = x;
    int xr = w - x;
    int yd = y;
    int yu = h - y;
    
    int min = (xl >= xr) ? xr : xl;
    min = (min >= yd) ? yd : min;
    min = (min >= yu) ? yu : min;
    
    printf("%d\n", min);

    return 0;
}
