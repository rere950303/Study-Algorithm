//
//  main.c
//  BaekJun Algorithm 21
//
//  Created by hyungwook on 2021/03/20.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    // insert code here...
    char *list[100];
    int n;
    int count = 0;
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        list[i] = malloc(101);
        scanf("%s", list[i]);
    }
    
    for(int i = 0; i < n; i++)
    {
        int k = 0;
        int j = 0;
        int alpha[26] = {0};
        unsigned long len = strlen(list[i]);
        
        while(j < len)
        {
            while(k < len - 1 && list[i][k] == list[i][k + 1])
            {
                k++;
            }
            alpha[list[i][k] - 97]++;
            k++;
            j = k;
        }

        for(int k = 0; k < 26; k++)
        {
            if(alpha[k] >= 2)
            {
                count++;
                break;
            }
        }
    }
    
    printf("%d\n", n - count);

    return 0;
}
