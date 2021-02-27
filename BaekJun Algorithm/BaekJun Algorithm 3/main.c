//
//  main.c
//  BaekJun Algorithm 3(다이얼, 5622)
//  https://www.acmicpc.net/problem/5622
//  Created by hyungwook on 2021/02/27.
//

#include <stdio.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    char s[16] = "";
    int i = 0;
    int result = 0;
    
    scanf("%s", s);
    
    while(s[i] != '\0')
    {
        if(s[i] >= 65 && s[i] <= 67)
            result += 3;
        else if(s[i] >= 68 && s[i] <= 70)
            result += 4;
        else if(s[i] >= 71 && s[i] <= 73)
            result += 5;
        else if(s[i] >= 74 && s[i] <= 76)
            result += 6;
        else if(s[i] >= 77 && s[i] <= 79)
            result += 7;
        else if(s[i] >= 80 && s[i] <= 83)
            result += 8;
        else if(s[i] >= 84 && s[i] <= 86)
            result += 9;
        else if(s[i] >= 87 && s[i] <= 90)
            result += 10;
        
        i++;
    }
    
    printf("%d\n", result);
    
    return 0;
}
