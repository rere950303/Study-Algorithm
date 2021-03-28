//
//  main.c
//  BaekJun Algorithm 48(17298, 오큰수)
//  https://www.acmicpc.net/problem/17298
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

int main(int argc, const char * argv[]) {
    // insert code here...
    IntStack s;
    int arr_before[1000000];
    int arr_after[1000000];
    int x, n;
    
    Initialize(&s, 1000000);
    memset(arr_after, -1, sizeof(arr_after));
    
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &arr_before[i]);
    }
    
    Push(&s, arr_before[n - 1]);
    
    for(int i = n - 2; i >= 0; i--)
    {
        Peek(&s, &x);
        if(x > arr_before[i])
        {
            Push(&s, arr_before[i]);
            arr_after[i] = x;
        }
        else
        {
            while(1)
            {
                if(s.ptr == 1)
                {
                    Pop(&s, &x);
                    Push(&s, arr_before[i]);
                    break;
                }
                Pop(&s, &x);
                Peek(&s, &x);
                if(x > arr_before[i])
                {
                    Push(&s, arr_before[i]);
                    arr_after[i] = x;
                    break;
                }
            }
        }
    }
    
    for(int i = 0; i < n; i++)
    {
        printf("%d ", arr_after[i]);
    }
    
    return 0;
}
