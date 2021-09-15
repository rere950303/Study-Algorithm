//
//  main.c
//  BaekJun Algorithm 16
//
//  Created by hyungwook on 2021/03/18.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *buff[20000];

void __mergesort(char *a[], int pl, int pr)
{
    if(pl < pr)
    {
        int j = 0;
        int p = 0;
        int pc = (pl + pr) / 2;
        int i;
        int k = pl;
        
        __mergesort(a, pl, pc);
        __mergesort(a, pc + 1, pr);
        
        for(i = pl; i <= pc; i++)
        {
            buff[p++] = a[i];
        }
        while(i <= pr && j < p)
        {
            if(strlen(buff[j]) < strlen(a[i]))
            {
                a[k++] = buff[j++];
            }
            else if((strlen(buff[j]) == strlen(a[i])) && (strcmp(buff[j], a[i]) < 0))
            {
                a[k++] = buff[j++];
            }
            else
            {
                a[k++] = a[i++];
            }
        }
        while(j < p)
        {
            a[k++] = buff[j++];
        }
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n = 0;
    char *list[20000];
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        list[i] = malloc(51);
        scanf("%s", list[i]);
    }

    __mergesort(list, 0, n - 1);
    
    printf("%s\n", list[0]);
    
    for(int i = 1; i < n; i++)
    {
        if(strcmp(list[i], list[i - 1]) != 0)
            printf("%s\n", list[i]);
    }

    return 0;
}
