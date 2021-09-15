//
//  main.c
//  BaekJun Algorithm 49(1874, 스택 수열)
//  https://www.acmicpc.net/problem/1874
//  Created by hyungwook on 2021/03/28.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int max;
    int ptr;
    int *stk;
} IntStack;

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
            a[k++] = (buff[j] <= a[i] ? buff[j++] : a[i++]);
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

int Initialize(IntStack *s, int max)
{
    s->max = max;
    s->ptr = 0;
    s->stk = malloc(sizeof(int) * max);
    
    return 0;
}

int Push(IntStack *s, int x)
{
    if(s->max <= s->ptr)
        return -1;
    
    s->stk[s->ptr] = x;
    s->ptr++;
    
    return 0;
}

int Pop(IntStack *s, int *x)
{
    if(s->ptr == 0)
        return -1;
    
    s->ptr--;
    *x = s->stk[s->ptr];
    
    return 0;
}

int Peek(IntStack *s, int *x)
{
    if(s->ptr <= 0)
        return -1;
    
    *x = s->stk[s->ptr - 1];
    return 0;
}

int Isempty(IntStack *s)
{
    if(s->ptr == 0)
        return 1;
    return 0;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    int n;
    IntStack s;
    int arr_before[100000];
    int arr_after[100000];
    int result[100000];
    char flag[200000];
    
    Initialize(&s, 100000);
    scanf("%d", &n);
    
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &arr_before[i]);
        arr_after[i] = arr_before[i];
    }
    
    mergesort1(arr_after, n);
    
    int x;
    int k = 0;
    int j = 0;
    int h = 0;
    int last = 0;
    
    while(k <= n - 1)
    {
        Push(&s, arr_after[k]);
        flag[h++] = '+';
        
        if(arr_after[k] == arr_before[j])
        {
            Pop(&s, &x);
            result[j++] = x;
            flag[h++] = '-';
            Peek(&s, &x);
            while(x == arr_before[j])
            {
                Pop(&s, &x);
                result[j++] = x;
                flag[h++] = '-';
                Peek(&s, &x);
            }
            k++;
        }
        else
            k++;
    }
    
    while(!Isempty(&s))
    {
        Pop(&s, &x);
        result[j] = x;
        j++;
    }
    
    for(; last < n; last++)
    {
        if(arr_before[last] != result[last])
        {
            printf("NO\n");
            break;
        }
    }
    
    if(last == n)
    {
        for(int i = 0; i < 2 * n; i++)
        {
            printf("%c\n", flag[i]);
        }
    }

    return 0;
}
