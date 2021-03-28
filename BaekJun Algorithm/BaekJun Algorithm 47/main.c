//
//  main.c
//  BaekJun Algorithm 47(10773, 제로)
//  https://www.acmicpc.net/problem/10773
//  Created by hyungwook on 2021/03/28.
//

#include <stdio.h>
#include <stdlib.h>

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

int Isempty(IntStack *s)
{
    if(s->ptr == 0)
        return 1;
    else
        return 0;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    IntStack s;
    int k;
    int x;
    long long sum = 0;
    
    Initialize(&s, 100000);
    scanf("%d", &k);
    
    for(int i = 0; i < k; i++)
    {
        scanf("%d", &x);
        if(x == 0)
            Pop(&s, &x);
        else
            Push(&s, x);
    }
    
    while(!Isempty(&s))
    {
        Pop(&s, &x);
        sum += x;
    }
    
    printf("%lld\n", sum);

    return 0;
}
