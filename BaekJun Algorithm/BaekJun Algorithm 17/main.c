//
//  main.c
//  BaekJun Algorithm 17
//
//  Created by hyungwook on 2021/03/18.
//

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int *buff;

void __mergesort(char a[], unsigned long pl, unsigned long pr)
{
    if(pl < pr)
    {
        int j = 0;
        int p = 0;
        unsigned long pc = (pl + pr) / 2;
        unsigned long i;
        unsigned long k = pl;
        
        __mergesort(a, pl, pc);
        __mergesort(a, pc + 1, pr);
        
        for(i = pl; i <= pc; i++)
        {
            buff[p++] = a[i];
        }
        while(i <= pr && j < p)
        {
            a[k++] = (buff[j] >= a[i] ? buff[j++] : a[i++]);
        }
        while(j < p)
        {
            a[k++] = buff[j++];
        }
    }
}

void mergesort1(char a[], unsigned long n)
{
    buff = calloc(n, sizeof(int));
    __mergesort(a, 0, n - 1);
    free(buff);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    long int x = 0;
    char arr[10];
    
    scanf("%ld", &x);
    
    sprintf(arr, "%ld", x);
    
    unsigned long len = strlen(arr);
    
    mergesort1(arr, len);
    
    printf("%s\n", arr);
    
    return 0;
}
