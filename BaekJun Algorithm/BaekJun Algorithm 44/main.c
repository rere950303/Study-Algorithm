//
//  main.c
//  BaekJun Algorithm 44(10828, 스택)
//  https://www.acmicpc.net/problem/10828
//  Created by hyungwook on 2021/03/27.
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

int Pop(IntStack *s)
{
    int x;
    
    if(s->ptr == 0)
        return -1;
    
    s->ptr--;
    x = s->stk[s->ptr];
    
    return x;
}

int Size(IntStack *s)
{
    return s->ptr;
}

int Isempty(IntStack *s)
{
    if(s->ptr == 0)
        return 1;
    else
        return 0;
}

int Top(IntStack *s)
{
    int x;
    if(s->ptr == 0)
        return -1;
    
    x = s->stk[s->ptr - 1];
    
    return x;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    IntStack s;
    int n;
    int x;
    char command[10];
    
    Initialize(&s, 10000);

    scanf("%d", &n);
    
    for(int i = 0; i < n; i++)
    {
        scanf("%s", command);
        if(strcmp(command, "push") == 0)
        {
            scanf("%d", &x);
            Push(&s, x);
        }
        else if(strcmp(command, "pop") == 0)
        {
            printf("%d\n", Pop(&s));
        }
        else if(strcmp(command, "size") == 0)
        {
            printf("%d\n", Size(&s));
        }
        else if(strcmp(command, "empty") == 0)
        {
            printf("%d\n", Isempty(&s));
        }
        else if(strcmp(command, "top") == 0)
        {
            printf("%d\n", Top(&s));
        }
    }
    
    return 0;
}
