//
//  main.c
//  BaekJun Algorithm 75(18870, 좌표 압축)
//  https://www.acmicpc.net/problem/18870
//  Created by hyungwook on 2021/04/29.
//

#include <stdio.h>
#include <stdlib.h>

int *buff;

void __mergesort(int a[], int pl, int pr)
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
            a[k++] = (buff[j] >= a[i] ? buff[j++] : a[i++]);
        }
        while(j < p)
        {
            a[k++] = buff[j++];
        }
    }
}

void mergesort1(int a[], int n)
{
    buff = calloc(n, sizeof(int));
    __mergesort(a, 0, n - 1);
    free(buff);
}

int bin_search(const int a[], int n, int key)
{
    int pl = 0;
    int pr = n - 1;
    int pc;
    do {
        pc = (pl + pr) / 2;
        if(a[pc] == key)
            return pc;
        else if(a[pc] < key)
            pr = pc - 1;
        else
            pl = pc + 1;
    } while(pl <= pr);
    return -1;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int vector1[1000000];
    int vector2[1000000];
    int vector3[1000000];
    int n;
    int k = 1;
    int j = 1;
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &vector1[i]);
        vector2[i] = vector1[i];
    }
    mergesort1(vector2, n);
    
    vector3[0] = vector2[0];
    
    while(k != n)
    {
        if(vector2[k] != vector2[k - 1])
        {
            vector3[j] = vector2[k];
            k++;
            j++;
        }
        else
        {
            k++;
        }
    }
    
    for(int i = 0; i < n; i++)
    {
        int idx = bin_search(vector3, j, vector1[i]);
        
        printf("%d ", j - idx - 1);
    }

    return 0;
}
