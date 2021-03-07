//
//  main.c
//  BaekJun Algorithm 13
//
//  Created by hyungwook on 2021/03/06.
//

#include <stdio.h>
#include <string.h>

void reverse(char s[])
{
    int len = strlen(s);
    
    for(int i = 0; i < len / 2; i++)
    {
        char c = s[i];
        s[i] = s[len - i - 1];
        s[len - i - 1] = c;
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    char a[10002] = "";
    char b[10002] = "";
    char c[10003] = "";
    int carry = 0;

    scanf("%s %s", a, b);
    
    int len = strlen(a) > strlen(b) ? strlen(a) : strlen(b);
    
    reverse(a);
    reverse(b);
    
    for(int i = 0; i < len; i++)
    {
        int sum = a[i] - '0' + b[i] - '0' + carry;
        
        while(sum < 0)
        {
            sum += '0';
        }
        
        if(sum >= 10)
            carry = 1;
        else
            carry = 0;
        
        c[i] = sum % 10 + '0';
    }

    if(carry == 1)
        c[len] = '1';
    
    reverse(c);
    
    printf("%s\n", c);
}
