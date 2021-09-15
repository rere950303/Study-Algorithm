//
//  main.c
//  BaekJun Algorithm 121(회의실 배정, 1931)
//  https://www.acmicpc.net/problem/1931
//  Created by hyungwook on 2021/06/22.
//

#include <stdio.h>
#include <stdlib.h>

typedef struct conf {
    int a;
    int b;
} Conf;

Conf *buff;

void __mergesort1(Conf a[], int pl, int pr)
{
    if(pl < pr)
    {
        int j = 0;
        int p = 0;
        int pc = (pl + pr) / 2;
        int i;
        int k = pl;
        
        __mergesort1(a, pl, pc);
        __mergesort1(a, pc + 1, pr);
        
        for(i = pl; i <= pc; i++)
        {
            buff[p++] = a[i];
        }
        while(i <= pr && j < p)
        {
            a[k++] = (buff[j].b <= a[i].b ? buff[j++] : a[i++]);
        }
        while(j < p)
        {
            a[k++] = buff[j++];
        }
    }
}

void __mergesort2(Conf a[], int pl, int pr)
{
    if(pl < pr)
    {
        int j = 0;
        int p = 0;
        int pc = (pl + pr) / 2;
        int i;
        int k = pl;
        
        __mergesort2(a, pl, pc);
        __mergesort2(a, pc + 1, pr);
        
        for(i = pl; i <= pc; i++)
        {
            buff[p++] = a[i];
        }
        while(i <= pr && j < p)
        {
            a[k++] = (buff[j].a <= a[i].a ? buff[j++] : a[i++]);
        }
        while(j < p)
        {
            a[k++] = buff[j++];
        }
    }
}

void mergesort1(Conf a[], int n)
{
    buff = calloc(n, sizeof(Conf));
    __mergesort1(a, 0, n - 1);
    free(buff);
}

void mergesort2(Conf a[], int n)
{
    buff = calloc(n, sizeof(Conf));
    __mergesort2(a, 0, n - 1);
    free(buff);
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    Conf *p;
    int count = 1;
    
    scanf("%d", &n);
    p = calloc(n, sizeof(Conf));
    for(int i = 0; i < n; i++)
    {
        scanf("%d %d", &p[i].a, &p[i].b);
    }
        
    mergesort2(p, n);
    mergesort1(p, n);
    
    int min = p[0].b;

    for(int i = 1; i < n; i++)
    {
        if(p[i].a >= min)
        {
            count++;
            min = p[i].b;
        }
    }
    
    printf("%d\n", count);
    free(p);
    
    return 0;
}
