//
//  main.c
//  BaekJun Algorithm 119(스도쿠, 2580)
//  https://www.acmicpc.net/problem/2580
//  Created by hyungwook on 2021/06/21.
//

int flag_a[10][10];
int flag_b[10][10];
int flag_c[10][10][10];
int digit[10][10];
int count = 0;

#include <stdio.h>

void set(int a)
{
    int pc = ((a - 1) / 9) + 1;
    int pr = ((a - 1) % 9) + 1;
    
    if(digit[pc][pr] == 0)
    {
        for(int i = 1; i <= 9; i++)
        {
            if(flag_a[pc][i] == 0 && flag_b[pr][i] == 0 && flag_c[2 + 3 * ((pc - 1) / 3)][2 + 3 * ((pr - 1) / 3)][i] == 0)
            {
                digit[pc][pr] = i;
                flag_a[pc][i] = 1;
                flag_b[pr][i] = 1;
                flag_c[2 + 3 * ((pc - 1) / 3)][2 + 3 * ((pr - 1) / 3)][i] = 1;
                if(a < 81)
                {
                    set(a + 1);
                    if(count == 81)
                        return;
                    digit[pc][pr] = 0;
                    flag_a[pc][i] = 0;
                    flag_b[pr][i] = 0;
                    flag_c[2 + 3 * ((pc - 1) / 3)][2 + 3 * ((pr - 1) / 3)][i] = 0;
                }
                else
                {
                    count = a;
                    return;
                }
            }
        }
        if(digit[pc][pr] == 0)
            return;
    }
    if(a < 81)
        set(a + 1);
    else
    {
        count = a;
        return;
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    
    for(int i = 1; i <= 9; i++)
    {
        for(int j = 1; j <= 9; j++)
        {
            scanf("%d", &digit[i][j]);
            flag_a[i][digit[i][j]] = 1;
            flag_b[j][digit[i][j]] = 1;
            flag_c[2 + 3 * ((i - 1) / 3)][2 + 3 * ((j - 1) / 3)][digit[i][j]] = 1;
        }
    }
    
    set(1);
  
    for(int i = 1; i <= 9; i++)
    {
        for(int j = 1; j <=9 ; j++)
        {
            printf("%d ", digit[i][j]);
        }
        printf("\n");
    }
    
  
    return 0;
}
