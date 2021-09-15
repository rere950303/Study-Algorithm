//
//  main.c
//  BaekJun Algorithm 114(N-Queen, 9663)
//  https://www.acmicpc.net/problem/9663
//  Created by hyungwook on 2021/06/19.
//

#include <stdio.h>

int flag_a[14];
int flag_b[27];
int flag_c[27];
int count = 0;
int n;
int pos[14];

void set(int i)
{
    for(int j = 0; j < n; j++)
    {
        if(flag_a[j] == 0 && flag_b[i + j] == 0 && flag_c[i - j + n - 1] == 0)
        {
            pos[i] = j;
            if(i == n - 1)
            {
                count++;
            }
            else
            {
                flag_a[j] = flag_b[i + j] = flag_c[i - j + n - 1] = 1;
                set(i + 1);
                flag_a[j] = flag_b[i + j] = flag_c[i - j + n - 1] = 0;
            }
        }
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    
    scanf("%d", &n);
    set(0);
    
    printf("%d\n", count);
    
    return 0;
}
