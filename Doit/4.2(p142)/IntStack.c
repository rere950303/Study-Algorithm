//
//  main.c
//  4.1(p142)
//
//  Created by hyungwook on 2021/03/08.
//

#include <stdio.h>
#include <stdlib.h>
#include "IntStack.h"

int Initialize(IntStack *s, int max)
{
    s->ptr0 = 0;
    
    if ((s->stk = calloc(max, sizeof(int))) == NULL)
    {
        s->max = 0;
        return -1;
    }
    s->max = max;
    
    s->ptr1 = (s->max) - 1;

    return 0;
}

int Push(IntStack *s, int stack, int x)
{
    if(stack == 0)
    {
        if ((s->ptr0 + s->max - s->ptr1 - 1) >= s->max)
            return -1;
        s->stk[s->ptr0++] = x;
        return 0;
    }
    
    else
    {
        if ((s->ptr0 + s->max - s->ptr1 - 1) >= s->max)
            return -1;
        s->stk[s->ptr1--] = x;
        return 0;
    }

}

int Pop(IntStack *s, int stack, int *x)
{
    if(stack == 0)
    {
        if (s->ptr0 <= 0)
            return -1;
        *x = s->stk[--s->ptr0];
        return 0;
    }
    
    else
    {
        if (s->ptr1 >= s->max - 1)
            return -1;
        *x = s->stk[++s->ptr1];
        return 0;
    }
}

int Peek(const IntStack *s, int stack, int *x)
{
    if(stack == 0)
    {
        if (s->ptr0 <= 0)
            return -1;
        *x = s->stk[s->ptr0 - 1];
        return 0;
    }
    
    else
    {
        if (s->ptr1 >= s->max - 1)
            return -1;
        *x = s->stk[s->ptr1 + 1];
        return 0;
    }

}

void Clear(IntStack *s, int stack)
{
    if(stack == 0)
    {
        s->ptr0 = 0;
    }
    else
    {
        s->ptr1 = s->max - 1;
    }
}

int Capacity(const IntStack *s)
{
    return s->max;
}

int Size(const IntStack *s, int stack)
{
    if(stack == 0)
    {
        return s->ptr0;
    }
    
    else
    {
        return (s->max) - (s->ptr1) - 1;
    }
}

int Search(const IntStack *s, int stack, int x)
{
    int i;
    
    if(stack == 0)
    {
        for (i = s->ptr0 - 1; i >= 0; i--)
            if (s->stk[i] == x)
                return i;
        return -1;
    }
    
    else
    {
        for (i = s->ptr1 + 1; i < s->max; i++)
            if (s->stk[i] == x)
                return i;
        return -1;
    }
}

void Print(const IntStack *s, int stack)
{
    int i;
    
    if(stack == 0)
    {
        for (i = 0; i < s->ptr0; i++)
            printf("%d ", s->stk[i]);
        putchar('\n');
    }
    
    else
    {
        for (i = s->max - 1; i > s->ptr1; i--)
            printf("%d ", s->stk[i]);
        putchar('\n');
    }
}

void Terminate(IntStack *s)
{
    if (s->stk != NULL)
        free(s->stk);
    s->max = s->ptr1 = s->ptr0 = 0;
}
