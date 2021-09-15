//
//  main.c
//  BaekJun Algorithm 122(잃어버린 괄호, 1541)
//  https://www.acmicpc.net/problem/1541
//  Created by hyungwook on 2021/06/23.
//

#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    char cal[51];
    int digit[51];
    char sign[51];
    int count = 0;
    
    scanf("%s", cal);
    
    int len = strlen(cal);
    int pc = len - 1;
    int pr = 0;
    int sum = 0;
    
    while(true)
    {
        if(cal[pc] == '+')
        {
            sign[count] = cal[pc--];
            digit[count++] = sum;
            sum = 0;
            pr = 0;
            if(pc == 0)
            {
                digit[count++] = cal[pc] - '0';
                break;
            }
        }
        
        else if(cal[pc] == '-')
        {
            sign[count] = cal[pc--];
            digit[count++] = sum;
            sum = 0;
            pr = 0;
            if(pc == 0)
            {
                digit[count++] = cal[pc] - '0';
                break;
            }
        }
        
        else
        {
            sum += pow(10, pr++) * (cal[pc--] - '0');
            if(pc == 0)
            {
                sum += pow(10, pr) * (cal[pc] - '0');
                digit[count++] = sum;
                break;
            }
            else if(pc == -1)
            {
                digit[count++] = sum;
                break;
            }
        }
    }

    sum = 0;
    int parentheses = 0;
    int final[51];
    
    for(int i = 0; i < count - 1; i++)
    {
        if(sign[i] == '+')
        {
            sum += digit[i];
            if(i == count - 2)
                final[parentheses++] = sum;
        }
        
        else
        {
            sum += digit[i];
            final[parentheses++] = sum * -1;
            sum = 0;
        }
    }
    
    final[parentheses++] = digit[count - 1];
    
    int ans = 0;
    
    for(int i = 0; i < parentheses; i++)
    {
        ans += final[i];
    }
    
    printf("%d\n", ans);

    return 0;
}
