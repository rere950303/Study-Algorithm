//
//  main.c
//  BaekJun Algorithm 110(OX퀴즈, 8958)
//  https://www.acmicpc.net/problem/8958
//  Created by hyungwook on 2021/06/07.
//

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    char arr[80];
    
    scanf("%d", &n);
    
    for(int i = 0; i < n; i++)
    {
        int flag = 0;
        int sum = 0;
        
        scanf("%s", arr);
        
        int length = strlen(arr);
        
        for(int j = 0; j < length; j++)
        {
            if(arr[j] == 'O')
            {
                flag += 1;
                sum += flag;
            }
            else
            {
                flag = 0;
            }
        }
        
        printf("%d\n", sum);
    }
  
    return 0;
}
